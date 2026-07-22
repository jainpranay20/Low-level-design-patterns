package CoreDesignPattern.Chain_of_Responsibility;

// LeaveRequest.java
class LeaveRequest {
    private int days;

    public LeaveRequest(int days) {
        this.days = days;
    }

    public int getDays() {
        return days;
    }
}

// Approver.java
abstract class Approver {

    protected Approver next;

    public void setNext(Approver next) {
        this.next = next;
    }

    public abstract void approve(LeaveRequest request);
}

// TeamLead.java
class TeamLead extends Approver {

    @Override
    public void approve(LeaveRequest request) {

        if (request.getDays() <= 2) {
            System.out.println("Approved by Team Lead");
        } else if (next != null) {
            System.out.println("Request is of " + request.getDays() + " proceeding to Manager");
            next.approve(request);
        }
    }
}

// Manager.java
class Manager extends Approver {

    @Override
    public void approve(LeaveRequest request) {

        if (request.getDays() <= 5) {
            System.out.println("Approved by Manager");
        } else if (next != null) {
            System.out.println("Request is of " + request.getDays() + " proceeding to Director");
            next.approve(request);
        }
    }
}

// Director.java
class Director extends Approver {

    @Override
    public void approve(LeaveRequest request) {
        System.out.println("Approved by Director");
    }
}

// Main.java
public class Main {

    public static void main(String[] args) {

        // Create handlers
        Approver teamLead = new TeamLead();
        Approver manager = new Manager();
        Approver director = new Director();

        // Build chain
        teamLead.setNext(manager);
        manager.setNext(director);

        // Requests
        teamLead.approve(new LeaveRequest(2));
        teamLead.approve(new LeaveRequest(4));
        teamLead.approve(new LeaveRequest(8));
    }
}