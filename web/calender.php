<?php

//----カレンダー作成------------------------
$year = date('Y'); //現在の年
$month = date('n'); //現在の月
$today = date('j'); //現在の日
//曜日の配列
$week = array("日", "月", "火", "水", "木", "金", "土");
//1日の曜日を数値で取得
$fir_week = date("w", mktime(0, 0, 0, $month, 1, $year));

echo '<table border="1" cellspacing="1" cellpadding="10" style="text-align:center;">';
//見出し部分出力
echo "<caption style=\"color:black; font-size:14px; padding:5px;\">"
	.$year. "年" .$month. "月のカレンダー
	</caption>";

echo "<tr>";

//曜日タグ設定
$i = 0; //カウント値リセット
while($i <= 6){ //曜日リセット

//----スタイルシート設定-------------------
	if($i == 0){
		$style = "#c30"; //日曜日の色
	}
	else if($i == 6){
		$style = "#03c"; //土曜日の色
	}
	else{
		$style = "black"; //月～金の色
	}
//----スタイルシート設定 end---------------

	//タグ挿入して出力
	echo '<th style=\'color:'.$style.'\'>'.$week[$i].'</th>';
	$i++;
}

//行の変更
echo '</tr>';
echo '<tr>';

$i = 0; //カウント値リセット（曜日カウンター）
while( $i != $fir_week ){ //１日の曜日まで空白（&nbsp;）で埋める
	echo "<td>&nbsp;</td>";
	$i ++;
}

//今月の日付けが存在している間ループ
for($day=1; checkdate($month, $day, $year); $day++){

	//曜日の最後まできたらカウント値を戻して行を変える
	if($i > 6){
		$i = 0;
		echo '</tr>';
		echo '<tr>';
	}

//----スタイルシートの設定------------------

	if($i == 0){
		$style = "#c30"; //日曜日の色
	}
	else if($i == 6){
		$style = "#03c"; //土曜日の色
	}
	else{
		$style = "black"; //月～金の色
	}

	//今日の背景色
	if($day == $today){
		$style = $style."; background:silver";
	}
//----スタイルシートの設定end---------------

	$date="$month. $day";


	//日付セル作成とスタイルシートの挿入
	echo 
	'<td style=\'color:'.$style.';\'>
		<form action="form.html" method="post">
			<input type="hidden" name="day" value="'.$date.'">'.$day.'
				<input type="submit" name="submit_add_day" value="予約">
		</form>
	</td>';
	
	$i++;
}

while($i < 7){ //残りの日数を埋める
	echo "<td>&nbsp;</td>";
	$i++;
}

echo '</tr>';
echo '</table>';

?>
