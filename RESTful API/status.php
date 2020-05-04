<?php
header("Access-Control-Allow-Origin: *");

    $servername = "firealermmonitoring.baishost.com";
    $username = "firealer_firealer";
    $password = "icui4cuK@";
    $dbname = "firealer_monitoringdb";

    $conn = new mysqli($servername, $username, $password, $dbname);
    // Check connection
    if ($conn->connect_error) {
        die("Connection failed: " . $conn->connect_error);
    }
    $sql = "SELECT  * FROM devices";

    $result = $conn->query($sql);

    $dataArray=array();

    if ($result->num_rows > 0) {
       
        while ($row = $result->fetch_assoc()) {

            array_push($dataArray,$row);
           
        }
    } else {
        echo "0 results";
    }

 echo json_encode($dataArray);
    $conn->close();

