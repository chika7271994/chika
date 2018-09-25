<?php
session_start();

if (isset($_SESSION["mail"])) {
    $errorMessage = "ログアウトしました。";
} else {
    $errorMessage = "セッションがタイムアウトしました。";
}

// セッションの変数のクリア
$_SESSION = array();

// セッションクリア
@session_destroy();
?>

<doctype html>
<html>
<head>
<meta http-equiv="content-type" charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Studio Photoshop</title>
	<link rel="stylesheet" href="css/header.css">
	<link rel="stylesheet" href="css/style.css">
	<link rel="stylesheet" href="css/sizuku.css">
	<link rel="stylesheet" href="css/form.css">

	<script src="./js/vendor/jquery-1.10.2.min.js"></script>
	<script src="./js/vendor/jquery-ui-1.10.3.custom.min.js"></script>
	<script src="./js/vendor/modernizr.custom.min.js"></script>

	<script src="./js/slide.js"></script>
	<script src="./js/sizuku.js"></script>

</head>
<body>
<div class="back">

	<!---header start--->
	<header class="page-header" role="banner">
	<div class="inner clearfix">
		<h1>Studio Photoshop</h1>
			<nav class="primary-nav" role="navigation">
				<li><a href="top.html">top</a></li>
				<li><a href="sample.html">sample</a></li>
				<li><a href="price.html">price</a></li>
				<li><a href="question.html">mail</a></li>
				<li><a href="index.html">index</a></li>
				<li><a href="signup.html">新規登録</a></li>
				<li><a href="logout.php">ログアウト</a></li>
			</nav>
	</div>
	</header>
	<!---header end--->

	<!---main start--->

<div id="logout">
<div class="logout">
<h3>ログアウト画面</h3>
<?php
echo $errorMessage; 
 echo nl2br("\n");
  echo nl2br("\n");
?>
</div>
</div>
<a href="top.html">戻る</a>

	<!---main end--->

<br>
<br>
<br>
<br>
<br>
	<!---footer start--->
	<footer>
		<p>&copy;Copyright Studio Photoshop. All rights reserved.</p>
	</footer>
	<!---footer end--->
</div>
</body>
</html>
