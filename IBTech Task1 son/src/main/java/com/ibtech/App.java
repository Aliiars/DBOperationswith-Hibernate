package com.ibtech;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.ibtech.dao.AccountDao;
import com.ibtech.dao.AddressDao;
import com.ibtech.dao.CustomerDao;
import com.ibtech.dao.PhoneDao;
import com.ibtech.model.Account;
import com.ibtech.model.Address;
import com.ibtech.model.Customer;
import com.ibtech.model.Phone;

public class App 
{
	public static void updateDatas(List<Customer> customerList, List<Account> accountList, List<Address> addressList, List<Phone> phoneList) {
    	CustomerDao customerDao = new CustomerDao();
    	AccountDao accountDao = new AccountDao();
    	AddressDao addressDao = new AddressDao();
    	PhoneDao phoneDao = new PhoneDao();	
    	
    	customerList.get(0).setName("Mina");
    	customerList.get(0).setSurname("Adam");
    	
    	accountList.get(0).setIban("TR003545");
    	
    	addressList.get(0).setCity("ŞanlıUrfa");
    	phoneList.get(0).setPhoneNumber("05684552535");
    	
    	
    	customerDao.updateCustomer(customerList.get(0));
    	accountDao.updateAccount(accountList.get(0));
    	addressDao.updateAddress(addressList.get(0));
    	phoneDao.updatePhone(phoneList.get(0));
	}
	
	public static void createDatas(List<Customer> customerList, List<Account> accountList, List<Address> addressList, List<Phone> phoneList) {
    	CustomerDao customerDao = new CustomerDao();
    	AccountDao accountDao = new AccountDao();
    	AddressDao addressDao = new AddressDao();
    	PhoneDao phoneDao = new PhoneDao();
    	
    	customerList.add(new Customer("ali baran", "arslan", "TR00001"));
    	customerList.add(new Customer("mehmet", "can", "TR00002"));
    	customerList.add(new Customer("beyza", "adam", "TR00003"));
    	customerList.add(new Customer("ahmet", "yaz", "TR00004"));

    	accountList.add(new Account("TR003505", "Credit", 35000, LocalDate.now(), customerList.get(0)));
    	accountList.add(new Account("TR003506", "Cash", 35100, LocalDate.now(), customerList.get(1)));
    	accountList.add(new Account("TR003507", "Limit", 35114, LocalDate.now(), customerList.get(2)));
    	accountList.add(new Account("TR003508", "Cash", 35101, LocalDate.now(), customerList.get(3)));

    	addressList.add(new Address("Turkey", "İstanbul", "Beyoğlu", "Yıldız st.", 34001, "alibaran.arslan@ibtech.com.tr",  customerList.get(0)));
    	addressList.add(new Address("Turkey", "İzmir", "Bornova", "Ergene st.", 35001, "beyza.adam@gmail.com",  customerList.get(1)));
    	addressList.add(new Address("Turkey", "Antalya", "Alanya", "Güneş st.", 7001, "beyza.demir@gmail.com",  customerList.get(2)));
    	addressList.add(new Address("Turkey", "İstanbul", "Beyoglu", "Yıldız st.", 34001, "ahmet.yaz@gmail.com",  customerList.get(3)));
    	
    	phoneList.add(new Phone("05323334554",  customerList.get(0)));
    	phoneList.add(new Phone("05323328525",  customerList.get(1)));
    	phoneList.add(new Phone("05456669575",  customerList.get(2)));
    	phoneList.add(new Phone("05478523695",  customerList.get(3)));
    	
    	customerList.forEach((n) -> customerDao.saveCustomer(n));
    	accountList.forEach((n) -> accountDao.saveAccount(n));
    	addressList.forEach((n) -> addressDao.saveAddress(n));
    	phoneList.forEach((n) -> phoneDao.savePhone(n));		
	}
	
	
	public static void getAllDatas(List<Customer> customerList, List<Account> accountList, List<Address> addressList, List<Phone> phoneList) {
    	CustomerDao customerDao = new CustomerDao();
    	AccountDao accountDao = new AccountDao();
    	AddressDao addressDao = new AddressDao();
    	PhoneDao phoneDao = new PhoneDao();
    	
    	System.out.println();
    	customerList.forEach((n) -> System.out.println(customerDao.getCustomerById(n.getId())));
    	System.out.println();
    	accountList.forEach((n) -> System.out.println(accountDao.getAccountById(n.getId())));
    	System.out.println();
    	addressList.forEach((n) -> System.out.println(addressDao.getAddressById(n.getId())));
    	System.out.println();
    	phoneList.forEach((n) -> System.out.println(phoneDao.getPhoneById(n.getId())));

	}
	
	public static void deleteAllDatas(List<Customer> customerList, List<Account> accountList, List<Address> addressList, List<Phone> phoneList) {
    	CustomerDao customerDao = new CustomerDao();
    	AccountDao accountDao = new AccountDao();
    	AddressDao addressDao = new AddressDao();
    	PhoneDao phoneDao = new PhoneDao();
    	
    	System.out.println();
    	accountList.forEach((n) -> accountDao.deleteAccount(n.getId()));
    	System.out.println();
    	addressList.forEach((n) -> addressDao.deleteAddress(n.getId()));
    	System.out.println();
    	phoneList.forEach((n) -> phoneDao.deletePhone(n.getId()));
    	System.out.println();
    	customerList.forEach((n) -> customerDao.deleteCustomer(n.getId()));
	}
    public static void main( String[] args )
    {
    	List<Customer> customerList = new ArrayList<Customer>();
    	List<Account> accountList = new ArrayList<Account>();
    	List<Address> addressList = new ArrayList<Address>();
    	List<Phone> phoneList = new ArrayList<Phone>();
    	
    	createDatas(customerList, accountList, addressList, phoneList);
    	updateDatas(customerList, accountList, addressList, phoneList);
    	getAllDatas(customerList, accountList, addressList, phoneList);
    	//deleteAllDatas(customerList, accountList, addressList, phoneList);

    }
}
