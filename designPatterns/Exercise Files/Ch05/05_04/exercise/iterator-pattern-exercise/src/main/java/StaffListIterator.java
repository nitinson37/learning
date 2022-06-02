import java.util.Iterator;

public class StaffListIterator implements Iterator {

    public StaffList staffList;
    int index;

    public StaffListIterator(StaffList staffList){
        this.staffList = staffList;
        index = 0;
    }

    public StaffList getStaffList() {
        return staffList;
    }

    @Override
    public boolean hasNext() {

        Employee[] employees = staffList.getEmployees();

        if(index < employees.length){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Employee next() {
        Employee[] employees = staffList.getEmployees();
        if(hasNext()){
            Employee employee = employees[index++];
            return employee;
        }
        else{
            return null;
        }
    }

    @Override
    public void remove() {
        Iterator.super.remove();
    }
}
