package t11_chainOfResp;

/**
 * 处理请求的类，责任链中的对象都需要继承该类，来实现具体的处理逻辑
 * 如果想要拓展，增加请求处理类的实现类即可，然后修改对象之间的层级关系，其余的都无需修改。
 */
public abstract class Leader {
	
	public static final int CompanyLeaderLevel = 0;
	public static final int DepartmentLeaderLevel = 10;
	public static final int TeamLeaderLevel = 20;
	public static final int EmployeeLevel = 30;
	
	private String name; // leader的名字
	private int level; // leader的等级，数字越大，等级越低
	private Leader nextLevel; // 上级，当请求无法处理的时候交由上级处理，也就是责任链的后继对象

	public Leader(String name, int level) {
		super();
		this.name = name;
		this.level = level;
	}

	public Leader(String name, int level, Leader nextLevel) {
		super();
		this.name = name;
		this.level = level;
		this.nextLevel = nextLevel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public Leader getNextLevel() {
		return nextLevel;
	}

	public void setNextLevel(Leader nextLevel) {
		this.nextLevel = nextLevel;
	}

	public abstract void handleRequest(Request request);
}

// 责任链中的一环
class CompanyLeader extends Leader {

	public CompanyLeader(String name) {
		// CompanyLeader的等级为0，最高级
		super(name, Leader.CompanyLeaderLevel);
	}

	@Override
	public void handleRequest(Request request) {
		// 没有CompanyLeader处理不了的请求
		if (request.getDays() <= 30) {
			System.out.println("CompanyLeader【" + this.getName() + "】同意了【" + request.getSponsor().getName() + "】发起的为期【"
					+ request.getDays() + "】天关于【" + request.getReason() + "】的申请，特此说明...");
		} else {
			System.out.println("【" + request.getSponsor().getName() + "】发起的为期【" + request.getDays() + "】天关于【"
					+ request.getReason() + "】的申请被驳回，特此说明...");
		}
	}
}

//责任链中的一环
class DepartmentLeader extends Leader {

	public DepartmentLeader(String name, Leader nextLevel) {
		super(name, Leader.DepartmentLeaderLevel, nextLevel);
	}

	@Override
	public void handleRequest(Request request) {
		// 如果请求发起人的 level 不低于 DepartmentLeader的level，则DepartmentLeader无法处理，直接交给其上级处理
		if (request.getSponsor().getLevel() <= Leader.DepartmentLeaderLevel) {
			this.getNextLevel().handleRequest(request);
		} else {
			if (request.getDays() <= 20) {
				System.out.println("DepartmentLeader【" + this.getName() + "】同意了【" + request.getSponsor().getName()
						+ "】发起的为期【" + request.getDays() + "】天关于【" + request.getReason() + "】的申请，特此说明...");
			} else {
				System.out.println("【" + request.getSponsor().getName() + "】发起的为期【" + request.getDays() + "】天关于【"
						+ request.getReason() + "】的申请被驳回，特此说明...");
			}
		}
	}
}

//责任链中的一环
class TeamLeader extends Leader {
	
	public TeamLeader(String name, Leader nextLevel) {
		super(name, Leader.TeamLeaderLevel, nextLevel);
	}

	@Override
	public void handleRequest(Request request) {
		// 如果请求发起人的 level 不低于 TeamLeader的level，则DepartmentLeader无法处理，直接交给其上级处理
		if (request.getSponsor().getLevel() <= Leader.TeamLeaderLevel) {
			this.getNextLevel().handleRequest(request);
		} else {
			if (request.getDays() <= 10) {
				System.out.println("DepartmentLeader【" + this.getName() + "】同意了【" + request.getSponsor().getName()
						+ "】发起的为期【" + request.getDays() + "】天关于【" + request.getReason() + "】的申请，特此说明...");
			} else {
				System.out.println("【" + request.getSponsor().getName() + "】发起的为期【" + request.getDays() + "】天关于【"
						+ request.getReason() + "】的申请被驳回，特此说明...");
			}
		}
	}
}

class Employee extends Leader {

	public Employee(String name, Leader nextLevel) {
		super(name, Leader.EmployeeLevel, nextLevel);
	}

	@Override
	public void handleRequest(Request request) {
		// 直接交给上级去处理
		this.getNextLevel().handleRequest(request);
	}
	
}