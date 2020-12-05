<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
	<head>
	<title>Banking Application | Login </title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="icon" href="images/favicon.ico">
		<link rel="shortcut icon" href="images/favicon.ico">
		<link rel="stylesheet" href="css/style.css">
		<script src="js/jquery.js"></script>
		<script src="js/jquery-migrate-1.1.1.js"></script>
		<script src="js/jquery.equalheights.js"></script>
		<script src="js/jquery.ui.totop.js"></script>
		<script src="js/jquery.easing.1.3.js"></script>
		<script>
		$(document).ready(function(){
			$().UItoTop({ easingType: 'easeOutQuart' });
		})
		</script>
		<!--[if lt IE 8]>
		<div style=' clear: both; text-align:center; position: relative;'>
			<a href="http://windows.microsoft.com/en-US/internet-explorer/products/ie/home?ocid=ie6_countdown_bannercode">
				<img src="http://storage.ie6countdown.com/assets/100/images/banners/warning_bar_0000_us.jpg" border="0" height="42" width="820" alt="You are using an outdated browser. For a faster, safer browsing experience, upgrade for free today." />
			</a>
		</div>
		<![endif]-->
		<!--[if lt IE 9]>
		<script src="js/html5shiv.js"></script>
		<link rel="stylesheet" media="screen" href="css/ie.css">
		<![endif]-->
		<!--[if lt IE 10]>
		<link rel="stylesheet" media="screen" href="css/ie1.css">
		<![endif]-->
		<!--===============================================================================================-->
	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
		
	</head>
	<body class="pt0">
<!--==============================header=================================-->
		
		
		<%
			if(session.getAttribute("sessionuser")!=null)
		%>
		<header>
		<script>
			window.history.farword();
		</script>
			<div class="container_12">
				<div class="grid_12">
					<h1><a href="index.html"><img src="images/logo.jpg" alt="Boo House"></a></h1>
					<div class="menu_block">
						<nav id="bt-menu" class="bt-menu">
							<a href="#" class="bt-menu-trigger"><span>Menu</span></a>
							<ul>
								<li class="bt-icon"><%@ include file="Logout.jsp" %></li>
								<li class="bt-icon"><a href="CreditDebit.jsp">Deposit</a></li>
								<li class="current bt-icon"><a href="withdraw.jsp">Withdraw</a></li>
								<li class="bt-icon"><a href="index-2.html">help</a></li>
								<li class="bt-icon"><a href="ViewBalance.jsp">View Account Balance</a></li>
									
							</ul>
						</nav>
						<div class="clear"></div>
					</div>
					<div class="clear"></div>
				</div>
			</div>
		</header>
<!--==============================Content=================================-->
	<!--===============================================================================================-->
	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
	
<!--===============================================================================================-->

	<div class="container-contact100">
		<div class="wrap-contact100">
			<form class="contact100-form validate-form" action="CreditDebit" method="post">
				<span class="contact100-form-title">
					Hello,Dear Customer Enter Amount
				</span>

				<div class="wrap-input100 validate-input" data-validate="Name is required">
					<span class="label-input100">Account Holder Name</span>
					<input class="input100" type="text" name="name" placeholder="Enter your name">
					<span class="focus-input100"></span>
				</div>		
				<div class="wrap-input100 input100-select">
					<span class="label-input100">Select Bank</span>
					<div>
						<select class="selection-2" name="bank">
							<option value="Punjab National Bank">Punjab National Bank</option>
							<option value="State Bank of India">State Bank of India</option>
							<option value="Canara Bank">Canara Bank</option>
							<option value="ICICI Bank">ICICI Bank</option>
							<option value="Karnataka Bank Ltd">Karnataka Bank Ltd</option>
							<option value="Karnataka Vikasa Bank">Karnataka Vikasa Bank</option>
							<option value="Bank of Baroda">Bank of Baroda</option>
							<option value="Syndicate Bank">Syndicate Bank</option>
							<option value="HDFC Bank">HDFC Bank</option>
							<option value="Kotaka Mahindra Bank">Kotaka Mahindra Bank</option>
							<option value="Alhabad Bank">Alhabad Bank</option>
							<option value="Vijaya Bank">Vijaya Bank</option>
							<option value="United Bank of India">United Bank of India</option>
							<option value="Central Bank of India">Central Bank of India</option>
							<option value="Oriental Bank of Commerce">Oriental Bank of Commerce</option>
							<option value="Indian Oversis Bank">Indian Oversis Bank</option>
							<option value="Corporation Bank">Corporation Bank</option>
							<option value="Bank of Maharashtra">Bank of Maharashtra</option>
							<option value="Andhra Bank">Andhra Bank</option>
							<option value="Axis Bank">Axis Bank</option>
							<option value="Dena Bank">Dena Bank</option>
						</select>
					</div>
					<div class="wrap-input100 input100-select">
					<span class="label-input100">Select Credit/Debit</span>
					<div>
						<select class="selection-2" name="type">
							<option value="Deposit">Deposit</option>
							<option value="Withdraw">Withdraw</option>
						</select>
					</div>
					<span class="focus-input100"></span>
				</div>
				<div class="wrap-input100 validate-input" data-validate = "Valid account number is required: 1234567890">
					<span class="label-input100">Account Number</span>
					<input class="input100" type="text" name="accno" placeholder="Enter your Valid Account Number">
					<span class="focus-input100"></span>
				</div>
				<div class="wrap-input100 validate-input" data-validate = "Valid IFSC code is required: PUNB0123000">
					<span class="label-input100">IFSC Code</span>
					<input class="input100" type="text" name="ifsc" placeholder="Enter your Valid IFSC Code" >
					<span class="focus-input100"></span>
				</div>
				<div class="wrap-input100 validate-input" data-validate = "Valid email Amount required:1000">
					<span class="label-input100">Enter Amount</span>
					<input class="input100" type="text" name="amount" placeholder="Enter Amount to Deposit">
					<span class="focus-input100"></span>
				</div>
				<div class="wrap-input100 validate-input" data-validate = "Valid valid date required:DD/MM/YYYY">
					<span class="label-input100">Enter Date</span>
					<input class="input100" type="text" name="date" placeholder="Enter date as DD/MM/YYYY">
					<span class="focus-input100"></span>
				</div>
				

				<div class="container-contact100-form-btn">
					<div class="wrap-contact100-form-btn">
						<div class="contact100-form-bgbtn"></div>
						<button class="contact100-form-btn">
							<span>
								Submit
								<i class="fa fa-long-arrow-right m-l-7" aria-hidden="true"></i>
							</span>
						</button>
						
					</div>
				</div>
			</form>
		</div>
	</div>



	<div id="dropDownSelect1"></div>

<!--===============================================================================================-->
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/select2/select2.min.js"></script>
	<script>
		$(".selection-2").select2({
			minimumResultsForSearch: 20,
			dropdownParent: $('#dropDownSelect1')
		});
	</script>
<!--===============================================================================================-->
	<script src="vendor/daterangepicker/moment.min.js"></script>
	<script src="vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="js/main.js"></script>

	<!-- Global site tag (gtag.js) - Google Analytics -->
<script async src="https://www.googletagmanager.com/gtag/js?id=UA-23581568-13"></script>
<script>
  window.dataLayer = window.dataLayer || [];
  function gtag(){dataLayer.push(arguments);}
  gtag('js', new Date());

  gtag('config', 'UA-23581568-13');
</script>

	
	
	
<!--==============================footer=================================-->
		<footer>
			<div class="container_12">
				<div class="grid_12">
					<div class="socials">
						<a href="#" class="fa fa-facebook"></a>
						<a href="#" class="fa fa-twitter"></a>
						<a href="#" class="fa fa-google-plus"></a>
					</div>
					<div class="clear"></div>
					<div class="copy">
						Online Banking &copy; 2014 | <a href="#">Privacy Policy</a> <br> Website designed by <a href="http://www.templatemonster.com/" rel="nofollow">TemplateMonster.com</a>
					</div>
				</div>
			</div>
		</footer>
		<script>
		$(document).ready(function(){
			$(".bt-menu-trigger").toggle(
				function(){
					$('.bt-menu').addClass('bt-menu-open');
				},
				function(){
					$('.bt-menu').removeClass('bt-menu-open');
				}
			);
		});
		</script>
		<%
			if(session.getAttribute("sessionuser")==null)
			{
				response.sendRedirect("Login.jsp");
			}
		%>
	</body>
</html>