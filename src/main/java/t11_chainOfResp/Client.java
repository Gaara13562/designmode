package t11_chainOfResp;

public class Client {
	public static void main(String[] args) {
		Leader boss = new CompanyLeader("BOSS");
		Leader ceo = new DepartmentLeader("CEO", boss);
		Leader captain = new TeamLeader("CAPTAIN", ceo);
		Leader emp1 = new Employee("Emp1", captain);
		Leader emp2 = new Employee("Emp2", captain);
		
		Request request1 = new Request(emp1, 5, "请假结婚");
		request1.beHandled(); //这里利用了一个小技巧，让请求自动寻找目标去处理
		new Request(emp2, 15, "请假结婚").beHandled();
		new Request(captain, 15, "请假结婚").beHandled();
		
	}
}
