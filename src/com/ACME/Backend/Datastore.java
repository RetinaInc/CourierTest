package com.ACME.Backend;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;


public class Datastore {
	public boolean insertUser(Users user) {
		Workbook myFirstWbook = null;
        WritableWorkbook workbookCopy = null;
        try {

            myFirstWbook = Workbook.getWorkbook(new File("Users.xls"));
            workbookCopy = Workbook.createWorkbook(new File("Users.xls"), myFirstWbook);
            WritableSheet sheetToEdit = workbookCopy.getSheet(0);
            int LastRow=sheetToEdit.getRows();
            
            Number number = new Number(0, LastRow, sheetToEdit.getCell(0, LastRow-1).getContents().equals("ID")?1:Integer.parseInt(sheetToEdit.getCell(0, LastRow-1).getContents())+1);
            sheetToEdit.addCell(number);

            Label label = new Label(1, LastRow, user.getUserName());
            sheetToEdit.addCell(label);

            label = new Label(2, LastRow, user.getRole());
            sheetToEdit.addCell(label);

            label = new Label(3, LastRow, user.getPassword());
            sheetToEdit.addCell(label);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (WriteException e) {
            e.printStackTrace();
            return false;
        } catch (BiffException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				workbookCopy.write();
				workbookCopy.close();
	            myFirstWbook.close();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (WriteException e) {
				e.printStackTrace();
			}
		}
	}
	public List<Users> getUsers() {
		List<Users> usersList = new ArrayList<>();
		 File inputWorkbook = new File("Users.xls");
	        Workbook w;
	        try {
	            w = Workbook.getWorkbook(inputWorkbook);
	            // Get the first sheet
	            Sheet sheet = w.getSheet(0);
	            // Loop over first 10 column and lines
	            for (int j = 1; j < sheet.getRows(); j++) {
	            		Users user = new Users(Integer.parseInt(sheet.getCell(0, j).getContents()), sheet.getCell(1, j).getContents(), sheet.getCell(2, j).getContents(), sheet.getCell(3, j).getContents());
	            		usersList.add(user);
	                }
	        } catch (BiffException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
				e.printStackTrace();
			} 
		return usersList;
	}
	public boolean updateUser(Users user) {
        List<Users> users = getUsers();
		Workbook myFirstWbook = null;
        WritableWorkbook workbookCopy = null;
        try {

            myFirstWbook = Workbook.getWorkbook(new File("Users.xls"));
            workbookCopy = Workbook.createWorkbook(new File("Users.xls"), myFirstWbook);
            WritableSheet sheetToEdit = workbookCopy.getSheet(0);
            int UpdatingRow=1;
            
            for(Users usr:users) {
            	if(usr.getUserid()==user.getUserid())
            		break;
            	else
            		UpdatingRow++;
            }
            
            Label label = new Label(1, UpdatingRow, user.getUserName());
            sheetToEdit.addCell(label);

            label = new Label(2, UpdatingRow, user.getRole());
            sheetToEdit.addCell(label);

            label = new Label(3, UpdatingRow, user.getPassword());
            sheetToEdit.addCell(label);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (WriteException e) {
            e.printStackTrace();
            return false;
        } catch (BiffException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				workbookCopy.write();
				workbookCopy.close();
	            myFirstWbook.close();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (WriteException e) {
				e.printStackTrace();
			}
		}
	}
	public boolean deleteUser(Users user) {
		List<Users> users = getUsers();
		int rowDelete=1;
		for(Users usr:users) {
			if(usr.getUserid()==user.getUserid())
				break;
			else
				rowDelete++;
		}
		Workbook myFirstWbook = null;
        WritableWorkbook workbookCopy = null;
        try {

            myFirstWbook = Workbook.getWorkbook(new File("Users.xls"));
            workbookCopy = Workbook.createWorkbook(new File("Users.xls"), myFirstWbook);
            WritableSheet sheetToEdit = workbookCopy.getSheet(0);
            sheetToEdit.removeRow(rowDelete);
            return true;
        }catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (BiffException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				workbookCopy.write();
				workbookCopy.close();
	            myFirstWbook.close();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (WriteException e) {
				e.printStackTrace();
			}
		}
		
	}
	public boolean insertCustomer(Customer cust) {
		Workbook myFirstWbook = null;
        WritableWorkbook workbookCopy = null;
        try {

            myFirstWbook = Workbook.getWorkbook(new File("Customers.xls"));
            workbookCopy = Workbook.createWorkbook(new File("Customers.xls"), myFirstWbook);
            WritableSheet sheetToEdit = workbookCopy.getSheet(0);
            int LastRow=sheetToEdit.getRows();
            
            Number number = new Number(0, LastRow, sheetToEdit.getCell(0, LastRow-1).getContents().equals("ID")?1:Integer.parseInt(sheetToEdit.getCell(0, LastRow-1).getContents())+1);
            sheetToEdit.addCell(number);

            Label label = new Label(1, LastRow, cust.getCustomerName());
            sheetToEdit.addCell(label);

            label = new Label(2, LastRow, cust.getLocation());
            sheetToEdit.addCell(label);

            label = new Label(3, LastRow, cust.getEmail());
            sheetToEdit.addCell(label);
            
            label = new Label(4, LastRow, cust.getPhno());
            sheetToEdit.addCell(label);
            
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (WriteException e) {
            e.printStackTrace();
            return false;
        } catch (BiffException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				workbookCopy.write();
				workbookCopy.close();
	            myFirstWbook.close();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (WriteException e) {
				e.printStackTrace();
			}
		}
	}
	public List<Customer> getCustomers() {
		List<Customer> custList = new ArrayList<>();
		 File inputWorkbook = new File("Customers.xls");
	        Workbook w;
	        try {
	            w = Workbook.getWorkbook(inputWorkbook);
	            Sheet sheet = w.getSheet(0);
	            for (int j = 1; j < sheet.getRows(); j++) {
	            	if(!sheet.getCell(0,j).getContents().isEmpty()&&!sheet.getCell(1,j).getContents().isEmpty()&&!sheet.getCell(2,j).getContents().isEmpty()&&!sheet.getCell(3,j).getContents().isEmpty()&&!sheet.getCell(4,j).getContents().isEmpty()){
	            		Customer cust = new Customer(Integer.parseInt(sheet.getCell(0, j).getContents()), sheet.getCell(1, j).getContents(), sheet.getCell(2, j).getContents(), sheet.getCell(3, j).getContents(),sheet.getCell(4, j).getContents());
	            		custList.add(cust);
	            	}
	                }
	        } catch (BiffException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
				e.printStackTrace();
			} 
		return custList;
	}
	public boolean updateCustomers(Customer cust) {
		 List<Customer> cms = getCustomers();
			Workbook myFirstWbook = null;
	        WritableWorkbook workbookCopy = null;
	        try {

	            myFirstWbook = Workbook.getWorkbook(new File("Customers.xls"));
	            workbookCopy = Workbook.createWorkbook(new File("Customers.xls"), myFirstWbook);
	            WritableSheet sheetToEdit = workbookCopy.getSheet(0);
	            int UpdatingRow=1;
	            
	            for(Customer cst:cms) {
	            	if(cst.getCustomerID()==cust.getCustomerID())
	            		break;
	            	else
	            		UpdatingRow++;
	            }
	            
	            Label label = new Label(1, UpdatingRow, cust.getCustomerName());
	            sheetToEdit.addCell(label);

	            label = new Label(2, UpdatingRow, cust.getLocation());
	            sheetToEdit.addCell(label);

	            label = new Label(3, UpdatingRow, cust.getEmail());
	            sheetToEdit.addCell(label);
	            
	            label = new Label(4, UpdatingRow, cust.getPhno());
	            sheetToEdit.addCell(label);
	            
	            return true;
	        } catch (IOException e) {
	            e.printStackTrace();
	            return false;
	        } catch (WriteException e) {
	            e.printStackTrace();
	            return false;
	        } catch (BiffException e) {
				e.printStackTrace();
				return false;
			} finally {
				try {
					workbookCopy.write();
					workbookCopy.close();
		            myFirstWbook.close();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (WriteException e) {
					e.printStackTrace();
				}
			}
	}
	public boolean deleteCustomers(Customer cust) {
		List<Customer> cms = getCustomers();
		int rowDelete=1;
		for(Customer cm:cms) {
			if(cm.getCustomerID()==cust.getCustomerID())
				break;
			else
				rowDelete++;
		}
		Workbook myFirstWbook = null;
        WritableWorkbook workbookCopy = null;
        try {

            myFirstWbook = Workbook.getWorkbook(new File("Customers.xls"));
            workbookCopy = Workbook.createWorkbook(new File("Customers.xls"), myFirstWbook);
            WritableSheet sheetToEdit = workbookCopy.getSheet(0);
            sheetToEdit.removeRow(rowDelete);
            return true;
        }catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (BiffException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				workbookCopy.write();
				workbookCopy.close();
	            myFirstWbook.close();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (WriteException e) {
				e.printStackTrace();
			}
		}
	}
	public boolean insertCompany(Company cmp) {
		Workbook myFirstWbook = null;
        WritableWorkbook workbookCopy = null;
        try {

            myFirstWbook = Workbook.getWorkbook(new File("Company.xls"));
            workbookCopy = Workbook.createWorkbook(new File("Company.xls"), myFirstWbook);
            WritableSheet sheetToEdit = workbookCopy.getSheet(0);
            int LastRow=1;

            Label label = new Label(0, LastRow, cmp.getName());
            sheetToEdit.addCell(label);

            label = new Label(1, LastRow, cmp.getContact());
            sheetToEdit.addCell(label);

            label = new Label(2, LastRow, cmp.getLoc());
            sheetToEdit.addCell(label);
            
            Number number = new Number(3, LastRow, cmp.getRate_Block());
            sheetToEdit.addCell(number);
            
            number = new Number(4, LastRow, cmp.getBlock_Miles());
            sheetToEdit.addCell(number);
            
            label = new Label(5, LastRow, cmp.getWorkhrs()+"");
            sheetToEdit.addCell(label);
            
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (WriteException e) {
            e.printStackTrace();
            return false;
        } catch (BiffException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				workbookCopy.write();
				workbookCopy.close();
	            myFirstWbook.close();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (WriteException e) {
				e.printStackTrace();
			}
		}
	}
	public List<Company> getCompany() {
		List<Company> cmpList = new ArrayList<>();
		 File inputWorkbook = new File("Company.xls");
	        Workbook w;
	        try {
	            w = Workbook.getWorkbook(inputWorkbook);
	            Sheet sheet = w.getSheet(0);
	            for (int j = 1; j < sheet.getRows(); j++) {
	            		if(!sheet.getCell(0,j).getContents().isEmpty()&&!sheet.getCell(1,j).getContents().isEmpty()&&!sheet.getCell(2,j).getContents().isEmpty()&&!sheet.getCell(3,j).getContents().isEmpty()&&!sheet.getCell(4,j).getContents().isEmpty()&&!sheet.getCell(5,j).getContents().isEmpty()){
	            		Company cmp = new Company(sheet.getCell(0, j).getContents(), sheet.getCell(1, j).getContents(), sheet.getCell(2, j).getContents(),Integer.parseInt(sheet.getCell(3, j).getContents()),Integer.parseInt(sheet.getCell(4, j).getContents()),sheet.getCell(5, j).getContents());
	            		cmpList.add(cmp);
	            		}
	                }
	        } catch (BiffException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
				e.printStackTrace();
			} 
		return cmpList;
	}
	public boolean updateCompany(Company cmp) {
		List<Company> cmps = getCompany();
		Workbook myFirstWbook = null;
        WritableWorkbook workbookCopy = null;
        try {

            myFirstWbook = Workbook.getWorkbook(new File("Company.xls"));
            workbookCopy = Workbook.createWorkbook(new File("Company.xls"), myFirstWbook);
            WritableSheet sheetToEdit = workbookCopy.getSheet(0);
            int UpdatingRow=1;
            
            for(Company cm:cmps) {
            	if(cm.getName().equals(cmp.getName()))
            		break;
            	else
            		UpdatingRow++;
            }
            
            Label label = new Label(1, UpdatingRow, cmp.getContact());
            sheetToEdit.addCell(label);

            label = new Label(2, UpdatingRow, cmp.getLoc());
            sheetToEdit.addCell(label);
            
            Number number = new Number(3, UpdatingRow, cmp.getRate_Block());
            sheetToEdit.addCell(number);
            
            number = new Number(4, UpdatingRow, cmp.getBlock_Miles());
            sheetToEdit.addCell(number);
            
            label = new Label(5, UpdatingRow, cmp.getWorkhrs()+"");
            sheetToEdit.addCell(label);
            
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (WriteException e) {
            e.printStackTrace();
            return false;
        } catch (BiffException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				workbookCopy.write();
				workbookCopy.close();
	            myFirstWbook.close();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (WriteException e) {
				e.printStackTrace();
			}
		}
	}
	public boolean deleteCompany(Company comp) {
		List<Company> cmp = getCompany();
		int rowDelete=1;
		for(Company cm:cmp) {
			if(cm.getName().equals(comp.getName()))
				break;
			else
				rowDelete++;
		}
		Workbook myFirstWbook = null;
        WritableWorkbook workbookCopy = null;
        try {

            myFirstWbook = Workbook.getWorkbook(new File("Company.xls"));
            workbookCopy = Workbook.createWorkbook(new File("Company.xls"), myFirstWbook);
            WritableSheet sheetToEdit = workbookCopy.getSheet(0);
            sheetToEdit.removeRow(rowDelete);
            return true;
        }catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (BiffException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				workbookCopy.write();
				workbookCopy.close();
	            myFirstWbook.close();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (WriteException e) {
				e.printStackTrace();
			}
		}
	}
	public boolean insertTicket(Ticket tkt) {
		Workbook myFirstWbook = null;
        WritableWorkbook workbookCopy = null;
        try {

            myFirstWbook = Workbook.getWorkbook(new File("Tickets.xls"));
            workbookCopy = Workbook.createWorkbook(new File("Tickets.xls"), myFirstWbook);
            WritableSheet sheetToEdit = workbookCopy.getSheet(0);
            int LastRow=sheetToEdit.getRows();

            Number number = new Number(0, LastRow, sheetToEdit.getCell(0, LastRow-1).getContents().equals("ID")?1:Integer.parseInt(sheetToEdit.getCell(0, LastRow-1).getContents())+1);
            sheetToEdit.addCell(number);
            
            number = new Number(1,LastRow,tkt.getCustomerID());
            sheetToEdit.addCell(number);
            
            Label label = new Label(2, LastRow, tkt.getLocation());
            sheetToEdit.addCell(label);
            
            label = new Label(3, LastRow, tkt.getDropLocation());
            sheetToEdit.addCell(label);

            label = new Label(4, LastRow, tkt.getCost()+"");
            sheetToEdit.addCell(label);
            
            label = new Label(5, LastRow, tkt.getDatetime());
            sheetToEdit.addCell(label);
            
            label = new Label(6, LastRow, tkt.getPickupdatetime());
            sheetToEdit.addCell(label);
            
            label = new Label(7, LastRow, tkt.getPkgid()+"");
            sheetToEdit.addCell(label);
            
            label = new Label(8, LastRow, tkt.getDelivery_person());
            sheetToEdit.addCell(label);
            
            label = new Label(9, LastRow, tkt.getAssignedTime());
            sheetToEdit.addCell(label);
            
            label = new Label(10, LastRow, tkt.getPickedupTime());
            sheetToEdit.addCell(label);
            
            label = new Label(11, LastRow, tkt.getDeliveredTime());
            sheetToEdit.addCell(label);
            
            label = new Label(12, LastRow, tkt.getBonus()+"");
            sheetToEdit.addCell(label);
            
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (WriteException e) {
            e.printStackTrace();
            return false;
        } catch (BiffException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				workbookCopy.write();
				workbookCopy.close();
	            myFirstWbook.close();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (WriteException e) {
				e.printStackTrace();
			}
		}
	}
	public List<Ticket> getTickets() {
		List<Ticket> tktList = new ArrayList<>();
		 File inputWorkbook = new File("Tickets.xls");
	        Workbook w;
	        try {
	            w = Workbook.getWorkbook(inputWorkbook);
	            // Get the first sheet
	            Sheet sheet = w.getSheet(0);
	            // Loop over first 10 column and lines
	            for (int j = 1; j < sheet.getRows(); j++) {
	            	if(!sheet.getCell(0,j).getContents().isEmpty()&&!sheet.getCell(1,j).getContents().isEmpty()&&!sheet.getCell(2,j).getContents().isEmpty()&&!sheet.getCell(3,j).getContents().isEmpty()&&!sheet.getCell(4,j).getContents().isEmpty()&&!sheet.getCell(5,j).getContents().isEmpty()&&!sheet.getCell(6,j).getContents().isEmpty()&&!sheet.getCell(7,j).getContents().isEmpty()&&!sheet.getCell(8,j).getContents().isEmpty()&&!sheet.getCell(9,j).getContents().isEmpty()&&!sheet.getCell(10,j).getContents().isEmpty()&&!sheet.getCell(11,j).getContents().isEmpty()&&!sheet.getCell(12,j).getContents().isEmpty()){
	            		Ticket tkt = new Ticket(Integer.parseInt(sheet.getCell(0, j).getContents()), Integer.parseInt(sheet.getCell(1, j).getContents()), sheet.getCell(2, j).getContents(),sheet.getCell(3, j).getContents(),Integer.parseInt(sheet.getCell(4, j).getContents()),sheet.getCell(5, j).getContents(),sheet.getCell(6, j).getContents(),Integer.parseInt(sheet.getCell(7, j).getContents()),sheet.getCell(8, j).getContents(),sheet.getCell(9, j).getContents(),sheet.getCell(10, j).getContents(),sheet.getCell(11, j).getContents(),Integer.parseInt(sheet.getCell(12,j).getContents()));
	            		tktList.add(tkt);
	            	}
	                }
	        } catch (BiffException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
				e.printStackTrace();
			} 
		return tktList;
	}
	public boolean updateTicket(Ticket tkt) {
		List<Ticket> tkts = getTickets();
		Workbook myFirstWbook = null;
        WritableWorkbook workbookCopy = null;
        try {

            myFirstWbook = Workbook.getWorkbook(new File("Tickets.xls"));
            workbookCopy = Workbook.createWorkbook(new File("Tickets.xls"), myFirstWbook);
            WritableSheet sheetToEdit = workbookCopy.getSheet(0);
            int UpdatingRow=1;
            
            for(Ticket tk:tkts) {
            	if(tk.getId()==tkt.getId())
            		break;
            	else
            		UpdatingRow++;
            }
            
            Number  number = new Number(1,UpdatingRow,tkt.getCustomerID());
            sheetToEdit.addCell(number);
            
            Label label = new Label(2, UpdatingRow, tkt.getLocation());
            sheetToEdit.addCell(label);
            
            label = new Label(3, UpdatingRow, tkt.getDropLocation());
            sheetToEdit.addCell(label);

            label = new Label(4, UpdatingRow, tkt.getCost()+"");
            sheetToEdit.addCell(label);
            
            label = new Label(5, UpdatingRow, tkt.getDatetime());
            sheetToEdit.addCell(label);
            
            label = new Label(6, UpdatingRow, tkt.getPickupdatetime());
            sheetToEdit.addCell(label);
            
            label = new Label(7, UpdatingRow, tkt.getPkgid()+"");
            sheetToEdit.addCell(label);
            
            label = new Label(8, UpdatingRow, tkt.getDelivery_person());
            sheetToEdit.addCell(label);
            
            label = new Label(9, UpdatingRow, tkt.getAssignedTime());
            sheetToEdit.addCell(label);
            
            label = new Label(10, UpdatingRow, tkt.getPickedupTime());
            sheetToEdit.addCell(label);
            
            label = new Label(11, UpdatingRow, tkt.getDeliveredTime());
            sheetToEdit.addCell(label);
            
            label = new Label(12, UpdatingRow, tkt.getBonus()+"");
            sheetToEdit.addCell(label);
            
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (WriteException e) {
            e.printStackTrace();
            return false;
        } catch (BiffException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				workbookCopy.write();
				workbookCopy.close();
	            myFirstWbook.close();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (WriteException e) {
				e.printStackTrace();
			}
		}
	}
	public boolean deleteTicket(Ticket tickets) {
		List<Ticket> tkts = getTickets();
		int rowDelete=1;
		for(Ticket tkt:tkts) {
			if(tkt.getId()==tickets.getId())
				break;
			else
				rowDelete++;
		}
		Workbook myFirstWbook = null;
        WritableWorkbook workbookCopy = null;
        try {

            myFirstWbook = Workbook.getWorkbook(new File("Tickets.xls"));
            workbookCopy = Workbook.createWorkbook(new File("Tickets.xls"), myFirstWbook);
            WritableSheet sheetToEdit = workbookCopy.getSheet(0);
            sheetToEdit.removeRow(rowDelete);
            return true;
        }catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (BiffException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				workbookCopy.write();
				workbookCopy.close();
	            myFirstWbook.close();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (WriteException e) {
				e.printStackTrace();
			}
		}
	}
}
