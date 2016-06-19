-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema negocio
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema negocio
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `negocio` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `negocio` ;

-- -----------------------------------------------------
-- Table `negocio`.`Ciudades`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `negocio`.`Ciudades` (
  `idCiudades` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCiudades`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `negocio`.`Clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `negocio`.`Clientes` (
  `idClientes` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `CP` CHAR(10) NOT NULL,
  `direccion` VARCHAR(45) NOT NULL,
  `cif` VARCHAR(45) NOT NULL,
  `Ciudades_idCiudades` INT NOT NULL,
  `telefono` CHAR(12) NOT NULL,
  `cuentabanc` CHAR(20) NOT NULL,
  PRIMARY KEY (`idClientes`),
  INDEX `fk_Clientes_Ciudades_idx` (`Ciudades_idCiudades` ASC),
  CONSTRAINT `fk_Clientes_Ciudades`
    FOREIGN KEY (`Ciudades_idCiudades`)
    REFERENCES `negocio`.`Ciudades` (`idCiudades`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `negocio`.`Pedidos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `negocio`.`Pedidos` (
  `idPedidos` INT NOT NULL AUTO_INCREMENT,
  `fecha` DATE NOT NULL,
  `estado` CHAR(1) NOT NULL,
  `Clientes_idClientes` INT NOT NULL,
  PRIMARY KEY (`idPedidos`),
  INDEX `fk_Facturas_Clientes1_idx` (`Clientes_idClientes` ASC),
  CONSTRAINT `fk_Facturas_Clientes1`
    FOREIGN KEY (`Clientes_idClientes`)
    REFERENCES `negocio`.`Clientes` (`idClientes`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `negocio`.`Paquetes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `negocio`.`Paquetes` (
  `idPaquetes` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `precio` VARCHAR(45) NOT NULL,
  `numero` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`idPaquetes`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `negocio`.`Pedido_linea`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `negocio`.`Pedido_linea` (
  `Pedidos_idPedidos` INT NOT NULL,
  `cantidad` INT UNSIGNED NOT NULL,
  `Paquetes_idPaquetes` INT NOT NULL,
  PRIMARY KEY (`Pedidos_idPedidos`, `Paquetes_idPaquetes`),
  INDEX `fk_Factura_linea_Paquetes1_idx` (`Paquetes_idPaquetes` ASC),
  CONSTRAINT `fk_Factura_linea_Facturas1`
    FOREIGN KEY (`Pedidos_idPedidos`)
    REFERENCES `negocio`.`Pedidos` (`idPedidos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Factura_linea_Paquetes1`
    FOREIGN KEY (`Paquetes_idPaquetes`)
    REFERENCES `negocio`.`Paquetes` (`idPaquetes`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
