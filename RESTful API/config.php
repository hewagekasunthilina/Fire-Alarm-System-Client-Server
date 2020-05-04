<?php

class Connect extends PDO{
    public function _construct(){
        parent::_construct("mysql:localhost","monitoringdb", 'root', 'root',
        array(PDO::MYSQL_ATTR_INIT_COMMAND => "SET DEVICES utf8"));

        $this -> setAttribute(PDO :: ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
        $this -> setAttribute(PDO :: ATTR_EMULATE_PREPARES, false);
    }
}
?>