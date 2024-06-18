<?php
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "productmovie";
 
// tạo connection
//$conn = new mysqli($servername, $username, $password, $dbname);
$conn = mysqli_connect($servername, $username, $password, $dbname);
mysqli_set_charset($conn, "utf8mb4");

// kiểm connection
// if ($conn->connect_error) {
//     die("Connection failed: " . $conn->connect_error);
// }

// $query = "SELECT * FROM `products`";
// $data = mysqli_query($conn,$query);
// $result = array();
// while ($row = mysqli_fetch_assoc($data)) {
//     $result[] = ($row['id']);
//     $result[] = ($row['name']);
// }

// // Kiểm tra kết quả
// if (!empty($result)) {
//     $arr = [
//         'success' => true,
//         'message' => "thanh cong",
//         'result' => $result
//     ];
// } else {
//     $arr = [
//         'success' => false,
//         'message' => "ko thanh cong",
//         'result' => $result
//     ];
// }

// print_r (json_encode($arr));