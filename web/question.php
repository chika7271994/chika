<?php
function h($str) {
	return htmlspecialchars($str, ENT_QUOTES, 'UTF-8');
}

//MySQLサーバに必要な値を代入
$host = 'localhost';
$username = 'root';
$password = '';
$db_name = 'studio';

//変数設定をして、サーバに接続
$database = mysqli_connect($host, $username, $password, $db_name);

//接続確認、未接続の場合エラー出力
if ($database == false){
	die('Connect Error ('.mysqli_connect_errno(). ')'.mysqli_connect_error());
}

//MySQLにutf8で接続
$charset = 'utf8';
mysqli_set_charset($database, $charset);

//データベース登録
if ($_POST['submit_add_question']) {
	$sql = 'INSERT INTO question (name, mail, message) VALUES(?, ?, ?)';
	$statement = mysqli_prepare($database, $sql);
	mysqli_stmt_bind_param($statement, 'sss', $_POST['name'], $_POST['mail'], $_POST['message']);
	mysqli_stmt_execute($statement);
	mysqli_stmt_close($statement);
	}else{
		echo "送信できませんでした";
}

mysqli_close($database);

//言語と文字コードの使用宣言
mb_language("Japanese");
mb_internal_encoding("UTF-8");

// 宛先
$to = $_POST['mail'];

// 件名
$subject = "メールの送信テスト";

// 本文
$text = $_POST['message'];

// 送信元
$from = "てすと！ ";

// 送信元メールアドレス
$from_mail = "tika7271994@yahoo.co.jp";

// 送信者名
$from_name = "PHPより";

// 送信者情報の設定
$header = '';
$header .= "Content-Type: text/plain charset=ISO-2022-JP \r\n";
$header .= "Return-Path: " . $from_mail . " \r\n";
$header .= "From: " . $from ." \r\n";
$header .= "Sender: " . $from ." \r\n";
$header .= "Reply-To: " . $from_mail . " \r\n";
$header .= "Organization: " . $from_name . " \r\n";
$header .= "X-Sender: " . $from_mail . " \r\n";
$header .= "X-Priority: 3 \r\n";

//メール送信
$response = mb_send_mail( $to, $subject, $text, $header);

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
<div id="question">
<div class="question">
<?php
echo nl2br("\n");
echo "お名前　　　　　　:　" .$_POST['name'];
echo nl2br("\n");
echo "メールアドレス　　:　" .$_POST['mail'];
echo nl2br("\n");
echo "お問い合わせ内容　:　" .$_POST['message'];
echo nl2br("\n");
echo nl2br("\n");
echo "以上の内容で送信が完了しました";
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
