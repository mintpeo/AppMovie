<?php
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "productmovie";
mysqli_set_charset($conn, "utf8mb4");

$email = $_POST['email'];
$pass = $_POST['pass'];

$conn = mysqli_connect($servername, $username, $password, $dbname);
mysqli_set_charset($conn, "utf8mb4");

//ORDER BY id DESC LIMIT 6
$query = 'SELECT * FROM `user` WHERE `email`= "'.$email.'" AND `pass` = "'.$pass.'"  ';
$data = mysqli_query($conn,$query);
$result = array();
while ($row = mysqli_fetch_assoc($data)) {
    $result[] = ($row);
}

// Kiểm tra kết quả
if (!empty($result)) {
    $arr = [
        'success' => true,
        'message' => "thanh cong",
        'result' => $result
    ];
} else {
    $arr = [
        'success' => false,
        'message' => "ko thanh cong",
        'result' => $result
    ];
}

print_r (json_encode($arr));