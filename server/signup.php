<?php
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "productmovie";
$conn = mysqli_connect($servername, $username, $password, $dbname);

mysqli_set_charset($conn, "utf8mb4");

$email = $_POST['email'];
$pass = $_POST['pass'];

// Check duplicate emails
$query = 'SELECT * FROM `user` WHERE `email` ="'.$email.'"';
$data = mysqli_query($conn,$query);
$numrow = mysqli_num_rows($data);
if ($numrow>0) { 
     $arr = [
        'success' => false,
        'message' => "Email đã tồn tại!"
];
} else {
    $query = 'INSERT INTO `user`(`email`,`pass`) VALUES("'.$email.'","'.$pass.'")';
    $data = mysqli_query($conn,$query);
    // Kiểm tra kết quả
    if ($data == true) {
        $arr = [
            'success' => true,
            'message' => "Success"
        ];
    } else {
        $arr = [
            'success' => false,
            'message' => "Failure"
        ];
    }
}

print_r(json_encode($arr));
?>
