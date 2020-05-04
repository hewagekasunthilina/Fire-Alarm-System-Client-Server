<?php
header("Access-Control-Allow-Origin: *");

$device_id =$_POST['device_id'];
$device_status =$_POST['device_status'];
$device_floor= $_POST['device_floor'];
$device_room= $_POST['device_room'];
$device_smoke= $_POST['device_smoke'];
$device_co2 = $_POST['device_co2'];

    $servername = "firealermmonitoring.baishost.com";
    $username = "firealer_firealer";
    $password = "icui4cuK@";
    $dbname = "firealer_monitoringdb";

    // Create connection
    $conn = new mysqli($servername, $username, $password, $dbname);
    // Check connection
    if ($conn->connect_error) {
        die("Connection failed: " . $conn->connect_error);
    }
 
    $sql =  "INSERT INTO devices (device_id, device_status, device_floor,device_room,device_smoke,device_co2)
VALUES ('$device_id', '$device_status', '$device_floor','$device_room','$device_smoke','$device_co2')";

if ($conn->query($sql) === TRUE) {
    echo "Fire Alarm Details Added Successfully";
} else {
    echo "Error: " . $sql . "<br>" . $conn->error;
}

    $conn->close();
?>