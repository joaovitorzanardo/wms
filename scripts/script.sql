-- DATABASE

CREATE DATABASE wms;

-- TABLES

CREATE TABLE orders (
  order_id INTEGER PRIMARY KEY,
  description VARCHAR(200),
  customer_id INTEGER NOT NULL,
  billed BOOLEAN DEFAULT false,
  billed_date DATE	
);

CREATE TABLE order_itens (
  order_itens_id INTEGER PRIMARY KEY,
  order_id INTEGER NOT NULL,
  product_id INTEGER NOT NULL,
  quantity INTEGER NOT NULL
);

CREATE TABLE customer (
  customer_id INTEGER PRIMARY KEY,
  first_name VARCHAR(200) NOT NULL,
  last_name VARCHAR(200) NOT NULL,
  email VARCHAR(200) NOT NULL UNIQUE,
  cpf varchar(11) NOT NULL UNIQUE,
  phone_number VARCHAR(11) NOT NULL,
  address_id INTEGER NOT NULL	
);

CREATE TABLE address (
  address_id INTEGER PRIMARY KEY,
  cep VARCHAR(8) NOT NULL,
  city VARCHAR(200) NOT NULL,
  uf VARCHAR(2) NOT NULL,
  street VARCHAR(200) NOT NULL,
  district VARCHAR(200) NOT NULL,
  number INTEGER NOT NULL
);

CREATE TABLE product (
  product_id INTEGER PRIMARY KEY,
  bar_code VARCHAR(200)	NOT NULL UNIQUE,
  name VARCHAR(200) NOT NULL,
  brand_id INTEGER NOT NULL,
  price FLOAT DEFAULT 0.0
);

CREATE TABLE brand (
  brand_id INTEGER PRIMARY KEY,
  name VARCHAR(200) NOT NULL
);

CREATE TABLE warehouse (
  warehouse_id INTEGER PRIMARY KEY,
  product_id INTEGER NOT NULL,
  quantity INTEGER NOT NULL
);

-- CONTRAINTS

ALTER TABLE orders ADD FOREIGN KEY (customer_id) REFERENCES customer(customer_id);

ALTER TABLE order_itens ADD FOREIGN KEY (order_id) REFERENCES orders(order_id);
ALTER TABLE order_itens ADD FOREIGN KEY (product_id) REFERENCES product(product_id);

ALTER TABLE product ADD FOREIGN KEY (brand_id) REFERENCES brand(brand_id);

ALTER TABLE warehouse ADD FOREIGN KEY (product_id) REFERENCES product(product_id);

-- SEQUENCES

CREATE SEQUENCE sequence_order START 1 INCREMENT 1;
CREATE SEQUENCE sequence_order_itens START 1 INCREMENT 1;
CREATE SEQUENCE sequence_customer START 1 INCREMENT 1;
CREATE SEQUENCE sequence_address START 1 INCREMENT 1;
CREATE SEQUENCE sequence_product START 1 INCREMENT 1;
CREATE SEQUENCE sequence_brand START 1 INCREMENT 1;
CREATE SEQUENCE sequence_warehouse START 1 INCREMENT 1;

-- PROCEDURES

CREATE OR REPLACE PROCEDURE public.saveproduct(
	IN productid integer,
	IN barcode text,
	IN namein text,
	IN brandname text,
	IN price double precision)
LANGUAGE 'plpgsql'
AS $BODY$
DECLARE
    vProductId integer;
	vBarCode varchar(200);
	vName varchar(200);
	vBrandId integer;
	vBrandName varchar(200);
	vPrice float;
BEGIN
    vProductId := productId;
	vBarCode := barcode;
	vName := nameIn;
	vBrandName := brandName;
	vPrice := price;
	
	select brand_id into vBrandId from brand where name = vBrandName;
	
	if (vProductId is not null) and (vProductId > 0) then
		update product set bar_code = vBarCode, name = vName, brand_id = vBrandId, price = vPrice
			where product_id = vProductId;
	else
		select * into vProductId from nextval('sequence_product');
		insert into product values (vProductId, vBarCode, vName, vBrandId, vPrice);
	end if;
	
END
$BODY$;

CREATE OR REPLACE PROCEDURE public.saveorder(
	IN orderid integer,
	IN descriptionorder text,
	IN customerid integer)
LANGUAGE 'plpgsql'
AS $BODY$
DECLARE
    vOrderId integer;
    vDescription text;
	vCustomerId integer;
BEGIN
    vOrderId := orderId;
	vDescription := descriptionOrder;
	vCustomerId := customerId;
	
	if (vOrderId is not null) and (vOrderId > 0) then
		update orders set description = vDescription, customer_id = vCustomerId
			where order_id = vOrderId;
	else
		select * into vOrderId from nextval('sequence_order');
		insert into orders values (vOrderId, vDescription, vCustomerId, false, null);
	end if;
			
END
$BODY$;

CREATE OR REPLACE PROCEDURE public.savecustomer(
	IN customerid integer,
	IN firstname text,
	IN lastname text,
	IN emailcustomer text,
	IN cpfcustomer text,
	IN phonenumber text,
	IN addressid integer)
LANGUAGE 'plpgsql'
AS $BODY$
DECLARE
    vCustomerId integer;
	vCustomerEmailInvalidId integer;
	vCustomerCpfInvalidId integer;
	vFirstName varchar(200);
	vLastName varchar(200);
	vEmail varchar(200);
	vCpf varchar(11);
	vPhoneNumber varchar(11);
	vAddressId integer;
BEGIN
    vCustomerId := customerId;
	vFirstName := firstName;
	vLastName := lastName;
	vEmail := emailCustomer;
	vCpf := cpfCustomer;
	vPhoneNumber := phoneNumber;
	vAddressId := addressId;
	
	if (vCustomerId is not null) and (vCustomerId > 0) then
		update customer set first_name = vFirstName, last_name = vLastName, 
			email = vEmail, cpf = vCpf, phone_number = vPhoneNumber, address_id = vAddressId
			where customer_id = vCustomerId;	
	else
		SELECT * INTO vCustomerId from nextval('sequence_customer');
		insert into customer values (vCustomerId, vFirstName, vLastName, vEmail, vCpf, vPhoneNumber, vAddressId);
	end if;
		
END
$BODY$;

CREATE OR REPLACE PROCEDURE public.savebrand(
	IN brandid integer,
	IN brandname text)
LANGUAGE 'plpgsql'
AS $BODY$
DECLARE
    vBrandId integer;
	vName varchar(200);
	vBrandIdExists integer;
	msg text;
BEGIN
    vBrandId := brandId; 
	vName := brandname;
	
	if (vBrandId is not null) and (vBrandId > 0) then
		UPDATE brand SET name = vName WHERE brand_id = vBrandId;
	else
		SELECT * INTO vBrandId from nextval('sequence_brand');
		INSERT INTO brand VALUES (vBrandId, vName);
	end if;
	
END
$BODY$;

CREATE OR REPLACE PROCEDURE public.saveaddress(
	IN addressid integer,
	IN cep text,
	IN city text,
	IN uf text,
	IN street text,
	IN district text,
	IN num integer)
LANGUAGE 'plpgsql'
AS $BODY$
DECLARE
    vAddressId integer;
	vCep varchar(8);
	vCity varchar(200);
	vUf varchar(2);
	vStreet varchar(200);
	vDistrict varchar(200);
	vNumber integer;
BEGIN
	vAddressId := addressId;
	vCep := cep;
	vCity := city;
	vUf := uf;
	vStreet := street;
	vDistrict := district;
	vNumber := num;
	
	if (vAddressId is not null) and (vAddressId > 0) then
		UPDATE address SET cep = vCep, city = vCity, uf = vUf, 
			street = vStreet, district = vDistrict, number = vNumber
		   WHERE address_id = vAddressId;
	else
		SELECT * INTO vAddressId from nextval('sequence_address');
		INSERT INTO address VALUES (vAddressId, vCep, vCity, vUf, vStreet, vDistrict, vNumber);
	end if;
	
END
$BODY$;

CREATE OR REPLACE PROCEDURE public.deleteproduct(
	IN productid integer)
LANGUAGE 'plpgsql'
AS $BODY$
DECLARE
    vProductId integer;
BEGIN
    vProductId := productId;
	
	delete from product where product_id = vProductId;

END
$BODY$;

CREATE OR REPLACE PROCEDURE public.deleteorder(
	IN orderid integer)
LANGUAGE 'plpgsql'
AS $BODY$
DECLARE
    vOrderId integer;
BEGIN
	vOrderId := orderId;

	delete from orders where order_id = vOrderId;
	
END
$BODY$;

CREATE OR REPLACE PROCEDURE public.deletecustomer(
	IN customerid integer)
LANGUAGE 'plpgsql'
AS $BODY$
DECLARE
    vCustomerId integer;
BEGIN
	vCustomerId := customerId;
	
	delete from customer where customer_id = vCustomerId;
	
END
$BODY$;

CREATE OR REPLACE PROCEDURE public.deletebrand(
	IN brandid integer)
LANGUAGE 'plpgsql'
AS $BODY$
DECLARE
    vBrandId integer;
BEGIN
    vBrandId := brandId;
	
	delete from brand where brand_id = vBrandId;
	
END
$BODY$;

CREATE OR REPLACE PROCEDURE public.deleteaddress(
	IN addressid integer)
LANGUAGE 'plpgsql'
AS $BODY$
DECLARE
    vAddressId integer;
BEGIN
	vAddressId := addressId;

	delete from address where address_id = vAddressId;

END
$BODY$;

CREATE OR REPLACE PROCEDURE public.ajustarestoque(
	IN barcode text,
	IN quantity integer)
LANGUAGE 'plpgsql'
AS $BODY$
DECLARE
    vWarehouseId integer;
	vWarehouseIdAlocado integer;
    vProductId integer;
	vBarCode varchar(200);
	vQuantity integer;
BEGIN
	vBarCode := barcode;
	vQuantity := quantity;
		
	select product_id into vProductId from product where bar_code = vBarCode;
	select warehouse_id into vWarehouseIdAlocado from warehouse where product_id = vProductId;
	
	if (vWarehouseIdAlocado is null) then
		SELECT * INTO vWarehouseId from nextval('sequence_warehouse');
		insert into warehouse values (vWarehouseId, vProductId, vQuantity);
	else
		update warehouse set product_id = vProductId, quantity = vQuantity where warehouse_id = vWarehouseIdAlocado;
	end if;
			
END
$BODY$;

-- VIEWS

CREATE OR REPLACE VIEW public.customers
 AS
 SELECT c.customer_id,
    c.first_name,
    c.last_name,
    c.email,
    c.cpf,
    c.phone_number,
    (((((ad.street::text || ', '::text) || ad.number) || ' - '::text) || ad.city::text) || ', '::text) || ad.uf::text AS address
   FROM customer c
     JOIN address ad ON c.address_id = ad.address_id;

CREATE OR REPLACE VIEW public.ordersview
 AS
 SELECT o.order_id,
    o.description,
    (cust.first_name::text || ' '::text) || cust.last_name::text AS customer,
    (((((ad.street::text || ', '::text) || ad.number) || ' - '::text) || ad.city::text) || ', '::text) || ad.uf::text AS address,
    o.billed,
    o.billed_date
   FROM orders o
     JOIN customer cust ON o.customer_id = cust.customer_id
     JOIN address ad ON cust.address_id = ad.address_id;

CREATE OR REPLACE VIEW public.products
 AS
 SELECT prod.product_id,
    prod.bar_code,
    prod.name,
    b.name AS brand,
    prod.price,
        CASE
            WHEN ware.quantity IS NULL THEN 0
            WHEN ware.quantity IS NOT NULL THEN ware.quantity
            ELSE NULL::integer
        END AS quantity
   FROM product prod
     JOIN brand b ON prod.brand_id = b.brand_id
     LEFT JOIN warehouse ware ON prod.product_id = ware.product_id;

-- TRIGGERS

CREATE OR REPLACE FUNCTION public.validate_product_deletion()
    RETURNS trigger
    LANGUAGE 'plpgsql'
AS $BODY$
DECLARE
	vProductIdOrder integer;
	vProductIdWarehouse integer;
BEGIN

    select product_id into vProductIdOrder from order_itens where product_id = old.product_id;
	select product_id into vProductIdWarehouse from warehouse  where product_id = old.product_id;
	
	if (vProductIdOrder is not null) then
		RAISE EXCEPTION 'Esse produto está vinculado a um pedido, não foi possível realizar a exclusão!';
	end if;
	
	if (vProductIdWarehouse is not null) then
		RAISE EXCEPTION 'Esse tem quantidade em estoque, não foi possível realizar a exclusão!';
	end if;
	
	RETURN OLD;
	
END;
$BODY$;

CREATE OR REPLACE FUNCTION public.validate_product()
    RETURNS trigger
    LANGUAGE 'plpgsql'
AS $BODY$
DECLARE
	vProductId boolean;
BEGIN
	
	select product_id into vProductId from product where bar_code = new.bar_code;
	
	if (vProductId is not null) then
		RAISE EXCEPTION 'Código Reduzido % já está cadastrado para outro produto!', new.bar_code;
	end if;
	
	RETURN NEW;
	
END;
$BODY$;

CREATE OR REPLACE FUNCTION public.validate_order_deletion()
    RETURNS trigger
    LANGUAGE 'plpgsql'
AS $BODY$
DECLARE
	vProductId integer;
	vIsBilled integer;
BEGIN

	select billed into vIsBilled from orders where order_id = old.order_id;
	select product_id into vProductId from order_itens where order_id = old.order_id;
	
	if (billed) then
		RAISE EXCEPTION 'Esse pedido já foi faturado, não foi possível realizar a exclusão!';
	end if;
	
	if (vProductId is not null) then
		RAISE EXCEPTION 'Existem produtos vinculados a esse pedido, não foi possível realizar a exclusão!';
	end if;
	
	RETURN OLD;
	
END;
$BODY$;

CREATE OR REPLACE FUNCTION public.validate_customer_deletion()
    RETURNS trigger
    LANGUAGE 'plpgsql'
AS $BODY$
DECLARE
	vCustomerOrderId integer;
BEGIN
	
	select customer_id into vCustomerOrderId from orders where customer_id = old.customer_id;
	
	if (vCustomerOrderId is not null) then
		RAISE EXCEPTION 'Existem pedidos vinculados a esse cliente, não foi possível realizar a exclusão!';
	end if;
	
	RETURN OLD;
	
END;
$BODY$;

CREATE OR REPLACE FUNCTION public.validate_customer()
    RETURNS trigger
    LANGUAGE 'plpgsql'
AS $BODY$
DECLARE
	vCustomerId integer;
	vEmailAlreadyRegistered boolean;
	vCpfAlreadyRegistered boolean;
BEGIN
	select customer_id is not null into vEmailAlreadyRegistered from customer where email = new.email;
	select customer_id is not null into vCpfAlreadyRegistered from customer where cpf = new.cpf;
	
	if (vEmailAlreadyRegistered) then
		RAISE EXCEPTION 'Já existe um cliente cadastrado com o email %!', vEmail;
	end if;
	
	if (vCpfAlreadyRegistered) then
		RAISE EXCEPTION 'Já existe um cliente cadastrado com o CPF %!', vCpf;
	end if;
	
	RETURN NEW;
	
END;
$BODY$;

CREATE OR REPLACE FUNCTION public.validate_brand_deletion()
    RETURNS trigger
    LANGUAGE 'plpgsql'
AS $BODY$
DECLARE
	vProductId integer;
BEGIN
	
	select product_id from product into vProductId where brand_id = old.brand_id;
	
	if (vProductId is not null) then
		RAISE EXCEPTION 'Existem produtos vinculados a essa marca, não foi possível realizar a exclusão!';
	end if;
	
	RETURN OLD;
	
END;
$BODY$;

CREATE OR REPLACE FUNCTION public.validate_brand()
    RETURNS trigger
    LANGUAGE 'plpgsql'
AS $BODY$
DECLARE
	vBrandId integer;
BEGIN
	
	select brand_id into vBrandId from brand where name = new.name;
	
	if (vBrandId is not null) then
		RAISE EXCEPTION 'Já existe uma marca com esse nome!';
	end if;
	
	RETURN NEW;
	
END;
$BODY$;

CREATE OR REPLACE FUNCTION public.validate_address_deletion()
    RETURNS trigger
    LANGUAGE 'plpgsql'
AS $BODY$
DECLARE
	vCustomerId integer;
BEGIN
	
	select customer_id into vCustomerId from customer where address_id = old.address_id;
	
	if (vCustomerId is not null) then
		RAISE EXCEPTION 'Existem clientes vinculados a esse endereço, não foi possível realizar a exclusão!';
	end if;
	
	RETURN OLD;
	
END;
$BODY$;

CREATE TRIGGER address_bd
    BEFORE DELETE
    ON public.address
    FOR EACH ROW
    EXECUTE FUNCTION public.validate_address_deletion();

CREATE TRIGGER brand_bd
    BEFORE DELETE
    ON public.brand
    FOR EACH ROW
    EXECUTE FUNCTION public.validate_brand_deletion();

CREATE TRIGGER brand_bi
    BEFORE INSERT
    ON public.brand
    FOR EACH ROW
    EXECUTE FUNCTION public.validate_brand();

CREATE TRIGGER brand_bu
    BEFORE UPDATE 
    ON public.brand
    FOR EACH ROW
    EXECUTE FUNCTION public.validate_brand();

CREATE TRIGGER customer_bd
    BEFORE DELETE
    ON public.customer
    FOR EACH ROW
    EXECUTE FUNCTION public.validate_customer_deletion();

CREATE TRIGGER customer_bi
    BEFORE INSERT
    ON public.customer
    FOR EACH ROW
    EXECUTE FUNCTION public.validate_customer();

CREATE TRIGGER customer_bu
    BEFORE UPDATE 
    ON public.customer
    FOR EACH ROW
    EXECUTE FUNCTION public.validate_customer();

CREATE TRIGGER order_bd
    BEFORE DELETE
    ON public.orders
    FOR EACH ROW
    EXECUTE FUNCTION public.validate_order_deletion();

CREATE TRIGGER product_bd
    BEFORE DELETE
    ON public.product
    FOR EACH ROW
    EXECUTE FUNCTION public.validate_product_deletion();

CREATE TRIGGER product_bi
    BEFORE INSERT
    ON public.product
    FOR EACH ROW
    EXECUTE FUNCTION public.validate_product();

CREATE TRIGGER product_bu
    BEFORE UPDATE 
    ON public.product
    FOR EACH ROW
    EXECUTE FUNCTION public.validate_product();

-- TYPES

CREATE TYPE product_row AS (
	product_id integer,
	bar_code varchar(200),
	name varchar(200),
	brand varchar(200),
	price float,
	quantity integer
);

-- FUNCTIONS

CREATE OR REPLACE FUNCTION public.getproductbynamelike(
	productname text)
    RETURNS SETOF product_row 
    LANGUAGE 'plpgsql'
AS $BODY$
declare
	vProductName text;
	
	vProductId integer;
	vBarCode varchar(200);
	vName varchar(200);
	vBrand varchar(200);
	vPrice float;
	vQuantity integer;
	
	Result product_row%rowtype;
	
	PRODUCTS_BY_NAME_LIKE cursor (cProductName text) is
		select * from products where name like '%' || cProductName || '%';
	
begin
	vProductName := productName;
	
	OPEN PRODUCTS_BY_NAME_LIKE(vProductName);
	fetch PRODUCTS_BY_NAME_LIKE into vProductId, vBarCode, vName, vBrand, vPrice, vQuantity;
	while found loop
		Result.product_id := vProductId;
		Result.bar_code := vBarCode;
		Result.name := vName;
		Result.brand := vBrand;
		Result.price := vPrice;
		Result.quantity := vQuantity;
		return next Result;
		fetch PRODUCTS_BY_NAME_LIKE into vProductId, vBarCode, vName, vBrand, vPrice, vQuantity;
	end loop;
	close PRODUCTS_BY_NAME_LIKE;
end;
$BODY$;
