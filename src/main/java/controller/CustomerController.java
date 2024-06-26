package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.KhachHangDAO;
import model.KhachHang;
import util.Email;
import util.MaHoa;
import util.RandomNumber;

/**
 * Servlet implementation class Customer
 */
@WebServlet("/customer")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CustomerController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equals("signin")) {
			signin(request, response);
		} else if (action.equals("logout")) {
			logout(request, response);
		} else if (action.equals("register")) {
			register(request, response);
		} else if (action.equals("change-password")) {
			changePassword(request, response);
		} else if (action.equals("change-information")) {
			changeInformation(request, response);
		} else if (action.equals("verify-email")) {
			verifyEmail(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void signin(HttpServletRequest request, HttpServletResponse response) {
		try {
			String username = request.getParameter("username");
			String password = request.getParameter("password");

			// ma hoa mat khau
			password = MaHoa.toSHA1(password);

			KhachHang kh = new KhachHang();
			kh.setUserName(username);
			kh.setPassword(password);

			KhachHangDAO khd = new KhachHangDAO();
			KhachHang khachHang = khd.selectByUsernameAndPassword(kh);
			String url = "";
			if (khachHang != null && khachHang.isTrangThaiXacThuc()) {
				HttpSession session = request.getSession();
				session.setAttribute("khachHang", khachHang);
				url = "/index.jsp";
			} else {
				request.setAttribute("errorMessage", "Username or password is invalid or account not verified");
				url = "/customer/signin.jsp";
			}
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void logout(HttpServletRequest request, HttpServletResponse response) {
		try {
			HttpSession session = request.getSession();
			// huy bo session
			session.invalidate();

			String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
					+ request.getContextPath();

			response.sendRedirect(url + "/index.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void register(HttpServletRequest request, HttpServletResponse response) {
		try {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String confirmPassword = request.getParameter("confirmPassword");
			String fullName = request.getParameter("fullName");
			String gender = request.getParameter("gender");
			String dateOfBirth = request.getParameter("dateOfBirth");
			String address = request.getParameter("address");
			String purchaseAddress = request.getParameter("purchaseAddress");
			String deliveryAddress = request.getParameter("deliveryAddress");
			String phoneNumber = request.getParameter("phoneNumber");
			String email = request.getParameter("email");
			String agreeToreceiveEmail = request.getParameter("agreeToreceiveEmail");

			// neu bao loi, giu lai thong tin da dien`
			request.setAttribute("username", username);
			request.setAttribute("fullName", fullName);
			request.setAttribute("gender", gender);
			request.setAttribute("dateOfBirth", dateOfBirth);
			request.setAttribute("address", address);
			request.setAttribute("purchaseAddress", purchaseAddress);
			request.setAttribute("deliveryAddress", deliveryAddress);
			request.setAttribute("phoneNumber", phoneNumber);
			request.setAttribute("email", email);
			request.setAttribute("agreeToreceiveEmail", agreeToreceiveEmail);

			String url = "";
			String errorMessage = "";
			KhachHangDAO khachHangDAO = new KhachHangDAO();
			if (khachHangDAO.checkUsername(username)) {
				errorMessage += "The username already exists, please choose another username.<br/>";
			}

			if (!password.equals(confirmPassword)) {
				errorMessage += "The passwords do not match, please re-enter your password.<br/>";
			} else {
				// ma hoa mat khau
				password = MaHoa.toSHA1(password);
			}

			request.setAttribute("errorMessage", errorMessage);

			if (errorMessage.length() > 0) {
				url = "/customer/register.jsp";
			} else {
				Random rd = new Random();
				String maKhachHang = System.currentTimeMillis() + rd.nextInt(1000) + "";
				KhachHang kh = new KhachHang(maKhachHang, username, password, fullName, gender, address,
						purchaseAddress, deliveryAddress, Date.valueOf(dateOfBirth), phoneNumber, email,
						agreeToreceiveEmail != null);
				if (khachHangDAO.insert(kh) > 0) {

					// lay ra day so xac thuc
					String randomNumber = RandomNumber.getRandomNumber();

					// quy dinh thoi gian hieu luc
					Date todaysDate = new Date(new java.util.Date().getTime());
					Calendar c = Calendar.getInstance();
					c.setTime(todaysDate);
					c.add(Calendar.DATE, 1);
					// c.add(Calendar.MINUTE, 1);
					Date thoiGianHieuLucXacThuc = new Date(c.getTimeInMillis());

					// trang thai xac thuc = false
					boolean trangThaiXacThuc = false;

					kh.setMaXacThuc(randomNumber);
					kh.setThoiGianHieuLucMaXacThuc(thoiGianHieuLucXacThuc);
					kh.setTrangThaiXacThuc(trangThaiXacThuc);

					if (khachHangDAO.updateVerifyInformation(kh) > 0) {
						// gui email cho khach hang
						Email.sendEmail(kh.getEmail(), "Xác thực tại khoản tại TAHENPIAOLIANG", getContent(kh));
					}

				}
				url = "/customer/signin.jsp";
			}
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void changePassword(HttpServletRequest request, HttpServletResponse response) {
		try {
			String currentPassword = request.getParameter("currentPassword");
			String newPassword = request.getParameter("newPassword");
			String confirmNewPassword = request.getParameter("confirmNewPassword");

			String currentPassword_Sha1 = MaHoa.toSHA1(currentPassword);

			String errorMessage = "";
			String url = "";

			// kiem tra mat khau cu co giong hay khong
			HttpSession session = request.getSession();
			Object obj = session.getAttribute("khachHang");
			KhachHang khachHang = null;
			if (obj != null)
				khachHang = (KhachHang) obj;

			if (khachHang == null) {
				errorMessage = "You are not logged into the system";
				url = "/customer/signin.jsp";
			} else {
				if (!currentPassword_Sha1.equals(khachHang.getPassword())) {
					errorMessage = "The current password is invalid!";
					url = "/customer/changepassword.jsp";
				} else {
					if (!newPassword.equals(confirmNewPassword)) {
						errorMessage = "The passwords do not match";
						url = "/customer/changepassword.jsp";
					} else {
						String newPassword_Sha1 = MaHoa.toSHA1(newPassword);
						khachHang.setPassword(newPassword_Sha1);
						KhachHangDAO khd = new KhachHangDAO();
						if (khd.changePassword(khachHang)) {
							errorMessage = "Password changed successfully!";
							url = "/index.jsp";
						} else {
							errorMessage = "Password change unsuccessful!";
							url = "/customer/changepassword.jsp";
						}
					}
				}
			}

			request.setAttribute("errorMessage", errorMessage);
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void changeInformation(HttpServletRequest request, HttpServletResponse response) {
		try {
			String fullName = request.getParameter("fullName");
			String gender = request.getParameter("gender");
			String dateOfBirth = request.getParameter("dateOfBirth");
			String address = request.getParameter("address");
			String purchaseAddress = request.getParameter("purchaseAddress");
			String deliveryAddress = request.getParameter("deliveryAddress");
			String phoneNumber = request.getParameter("phoneNumber");
			String email = request.getParameter("email");
			String agreeToreceiveEmail = request.getParameter("agreeToreceiveEmail");

			// neu bao loi, giu lai thong tin da dien`
			request.setAttribute("fullName", fullName);
			request.setAttribute("gender", gender);
			request.setAttribute("dateOfBirth", dateOfBirth);
			request.setAttribute("address", address);
			request.setAttribute("purchaseAddress", purchaseAddress);
			request.setAttribute("deliveryAddress", deliveryAddress);
			request.setAttribute("phoneNumber", phoneNumber);
			request.setAttribute("email", email);
			request.setAttribute("agreeToreceiveEmail", agreeToreceiveEmail);

			String url = "";
			String errorMessage = "";
			KhachHangDAO khachHangDAO = new KhachHangDAO();

			request.setAttribute("errorMessage", errorMessage);

			if (errorMessage.length() > 0) {
				url = "/customer/register.jsp";
			} else {
				Object obj = request.getSession().getAttribute("khachHang");
				KhachHang khachHang = null;
				if (obj != null) {
					khachHang = (KhachHang) obj;
					if (khachHang != null) {
						String maKhachHang = khachHang.getMaKhachHang();
						KhachHang kh = new KhachHang(maKhachHang, "", "", fullName, gender, address, purchaseAddress,
								deliveryAddress, Date.valueOf(dateOfBirth), phoneNumber, email,
								agreeToreceiveEmail != null);
						khachHangDAO.updateInfo(kh);
						KhachHang kh2 = khachHangDAO.selectById(kh);
						request.getSession().setAttribute("khachHang", kh2);
						errorMessage = "Information changed successfully";
						url = "/customer/changeinformation.jsp";
					}
				}

			}
			request.setAttribute("errorMessage", errorMessage);
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void verifyEmail(HttpServletRequest request, HttpServletResponse response) {
		try {
			String maKhachHang = request.getParameter("maKhachHang");
			String maXacThuc = request.getParameter("maXacThuc");

			KhachHangDAO khachHangDAO = new KhachHangDAO();
			KhachHang kh = new KhachHang();
			kh.setMaKhachHang(maKhachHang);

			KhachHang khachHang = khachHangDAO.selectById(kh);

			String msg = "";

			if (khachHang != null) {
				// kiem tra ma xac thuc duoc tao ra khi dang ky co giong voi ma xac thuc khach
				// hang nhap hay khong
				// kiem tra ma xac thuc con hieu luc hay khong
				if (khachHang.getMaXacThuc().equals(maXacThuc)
						&& khachHang.getThoiGianHieuLucMaXacThuc().after(new java.util.Date())) {
					// thanh cong
					khachHang.setTrangThaiXacThuc(true);
					khachHangDAO.updateVerifyInformation(khachHang);
					msg = "Successfully authenticated";
				} else {
					// that bai (ma sai)
					msg = "Authentication failed";
				}
			} else {
				msg = "Account does not exist";
			}
			String url = "/customer/notification.jsp";

			request.setAttribute("errorMessage", msg);
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static String getContent(KhachHang kh) {
		String link = "http://localhost:8080/Bai04-Bootstrap/customer?action=verify-email&maKhachHang="
				+ kh.getMaKhachHang() + "&maXacThuc=" + kh.getMaXacThuc();
		String content = "<!-- ####### HEY, I AM THE SOURCE EDITOR! #########-->\r\n"
				+ "<h1 style=\"color: #5e9ca0;\">TAHENPIAOLIANG</h1>\r\n"
				+ "<h2 style=\"color: #2e6c80;\">Ch&agrave;o bạn " + kh.getHoVaTen() + "!</h2>\r\n"
				+ "<p>Vui l&ograve;ng x&aacute;c thực tại khoản của bạn bằng m&atilde; <strong>" + kh.getMaXacThuc()
				+ "</strong>, hoặc click trực tiếp v&agrave;o đường link sau đ&acirc;y:&nbsp;</p>\r\n"
				+ "<p><strong>&nbsp;<a href=\"" + link + "\">" + link + "</a></strong></p>\r\n"
				+ "<p>Đ&acirc;y l&agrave; email tự động, vui l&ograve;ng kh&ocirc;ng phản hồi email n&agrave;y.</p>\r\n"
				+ "<p>Tr&acirc;n trọng cảm ơn!</p>\r\n"
				+ "<div class=\"ddict_btn\" style=\"top: 128px; left: 385.271px;\"><img src=\"chrome-extension://bpggmmljdiliancllaapiggllnkbjocb/logo/48.png\" /></div>";
		return content;
	}

}
