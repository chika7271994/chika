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

//データ取得

$num3 = 'SELECT d.day, p.time FROM date d, plan p WHERE d.id = p.id ORDER BY d.day ASC';
$result3 = mysqli_query($database, $num3);
while($row3 = mysqli_fetch_assoc($result3)){
	print$row3['day']. " ";
	print($row3['time']);
	echo nl2br("\n");
}

mysqli_close($database);

?>
