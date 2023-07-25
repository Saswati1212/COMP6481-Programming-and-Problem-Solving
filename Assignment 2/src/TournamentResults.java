
//.....................................................
// Assignment 2
// Part 2 
// Due Date : 11/27/2022
// Written by: Saswati Chowdhury, Student Id: 40184906
//.....................................................

import java.util.ArrayList;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Scanner;


/**
 * This class describes the Team details that include team id, team name, games
 * played, games own, games lost, net run rate and points.
 *
 * @author Saswati Chowdhury
 * @version 1.0
 */

/**
 * This class gives the tournament results.
 *
 */

public class TournamentResults {

  public static void main(String[] args) {
    TeamList list1 = new TeamList(); // for Group A
    TeamList list2 = new TeamList(); // for Group B
    Scanner sc = new Scanner(System.in);
    try {

		/*
		 * this part generated the Team objects by reading from the file and add it to
		 * the TeamList.
		 */

      String group = sc.nextLine(); //to sink in GROUP A
      HashSet<String> uniqueID = new HashSet<>();
      int lineCount = 0;
      int groupcount = 0;
      String line;
      while (!(line = sc.nextLine()).equals("")) {

        lineCount++;
        String[] splitLine = line.split(" ");
        // if (!uniqueID.contains(splitLine[0])) {
        // String teamID = splitLine[0];
        String teamName = splitLine[0];
        int gamesPlayed = Integer.parseInt(splitLine[1]);
        int gamesWon = Integer.parseInt(splitLine[2]);
        int gamesLost = Integer.parseInt(splitLine[3]);
        String run_rate = splitLine[4];
        double netRunRate = 0.000;
        if (run_rate.contains("+")) {
          run_rate = run_rate.replaceAll("\\+", "");
          netRunRate = Double.parseDouble(run_rate);
        } else if (run_rate.contains("-")) {
          run_rate = run_rate.replaceAll("-", "");
          netRunRate = 0.000 - Double.parseDouble(run_rate);
        }

        int points = Integer.parseInt(splitLine[5]);
        System.out.println("Enter team ID for: " + teamName);
        String teamID = sc.nextLine();
        Team team = null;
        if (!uniqueID.contains(teamID)) {
          System.out.println("creating the team object....");
          team = new Team(teamID, teamName, group, gamesPlayed, gamesWon, gamesLost, netRunRate, points);
          uniqueID.add(teamID);
        }
        else{
          System.out.println("cannot create this team as ID is not unique");
        }

        if ((lineCount <= 6) && (groupcount == 0)) {

          list1.addToStart(team);
          if (lineCount == 6) {
            groupcount++;
            sc.nextLine();// to sink in blank like
            group = sc.nextLine(); //to sink in "GROUP B"
          }
        } else if ((lineCount > 6) && (groupcount == 1)) {
          list2.addToStart(team);
        }
      }
      System.out.println("The team list of two groups is created!!");
      list1.printList(); // list1 for group A
      list2.printList(); // list2 for Group B

      ////////////////////////////////////////////////////

		/* This part makes the list of Teams which move to the next round or not. */

      System.out.println("Enter the request information");
      ArrayList<String> requests = new ArrayList<>();
      while (!(line = sc.nextLine()).equals("")) {
        requests.add(line);
      }

      System.out.println("requests" + requests);
      for (String request : requests) {
        if (list1.findShowWithName(request)) {
			// System.out.println("This team is in group 1");
          list1.findIfQualified(request);

        } else if (list2.findShowWithName(request)) {
			// System.out.println("This team is in the group 2");
          list2.findIfQualified(request);
        }
      }

		/*
		 * This part takes the few ShowIDs from the user to check whether the ShowList
		 * contains those IDs or not.
		 */
      sc = new Scanner(System.in);
      ArrayList<String> searchIDs = new ArrayList<>();
      System.out.print("How many teamIDs do you want to search:");
      int n = sc.nextInt();
      for (int i = 0; i < n; i++) {
        searchIDs.add(sc.next());
      }
      for (int i = 0; i < searchIDs.size(); i++) {
        if(list1.contains(searchIDs.get(i)))
        {
			System.out.println("in List 1");
        }
        else if (list2.contains(searchIDs.get(i))){
			System.out.println("in List 2");
        }
        else
        {
          System.out.println("Not Found in either list");
        }
      }

//      for (String searchID : searchIDs) {
//        list2.contains(searchID);
//      }

		// method testing
		/* This part shows the method testing here */
      System.out.println("\n\n-------Testing phase starts here-------\n");
      Team team1 = new Team("team1", "FINLAND", "GROUP A", 5, 4, 1, +2.464, 8);
      Team team2 = new Team("team2", "ZIMBABVE","GROUP A", 5, 4, 1, +1.162, 8);

      /*
       * Is in the same group testing
       */
		if (team2.isInTheGroup(team1)) { // same group
			System.out.println(
					"Team2: " + team2.getTeamName() + " and Team1: " + team1.getTeamName() + " are in the same group");
			// flag=0;
		} else { // different group
			System.out.println("Team2: " + team2.getTeamName() + " and Team1: " + team1.getTeamName()
					+ "are in the different group");
		}
		if (team1.equals(team2)) {
//       System.out.println("Printing this message proves that team1 and team2 are equal and copy constructor of TVShow class is working fine.");
        System.out.println(
            team1.getTeamID()
                + "     "
                + team2.getTeamID()
                + "\n"
                + team1.getTeamName()
                + "     "
                + team2.getTeamName()
                + "\n"
                + team1.getGamesPlayed()
                + "     "
                + team2.getGamesPlayed()
                + "\n"
                + team1.getGamesWon()
                + "     "
                + team2.getGamesWon()
                + "\n"
                + team1.getGamesLost()
                + "  "
                + team2.getGamesLost()
                + "\n"
                + team1.getNetRunRate()
                + "  "
                + team2.getNetRunRate()
                + "\n"
                + team1.getPoints()
                + "  "
                + team2.getPoints());
      }
      System.out.println("\n------Testing the cloning methods------\n");
      Team team3 = (Team) team2.clone();

      if (team3 != null) {
        System.out.println("\n***Deep Copies of Team***\n");
        System.out.println("team2: " + team2);
        System.out.println("team3: " + team3);
        System.out.println("**Result after changing the id for team3**");
        team3.setTeamID("1234");
        System.out.println("team2: " + team2);
        System.out.println("team3: " + team3);
      }

		/* Testing of TeamList class methods */
		Team team4 = new Team("team4", "PORTUGAL", "GROUP B", 5, 4, 1, +1.216, 8);
		System.out.println("\n----Testing of TeamList class methods-----\n");
      System.out.println("\n****Adding new nodes****\n");
      list2.addToStart(team1);
      System.out.println("team1 is added to the list");
      list2.printList();
      list2.addToStart(team4);
      System.out.println("team4 is added to the list");
      list2.printList();
      list2.insertAtIndex(team2, 1);
		System.out.println("team2 is added at index 1");
      list2.printList();

		/* Testing cloning method of TeamNode */

		System.out.println("\n---Testing cloning method of TeamNode---\n");
      TeamList.TeamNode teamNode = list2.getHead();
      TeamList.TeamNode cloningNode = (TeamList.TeamNode) teamNode.clone();
      System.out.println("**After Cloning**");
      System.out.println("original: " + teamNode.getTeam());
      System.out.println("Cloned: " + cloningNode.getTeam());
      cloningNode.getTeam().setTeamName("saswati");
		System.out.println("\n**After changing the team name of cloned object**");
      System.out.println("original: " + teamNode.getTeam());
      System.out.println("Cloned: " + cloningNode.getTeam());

		/* Delete the existing node */
      System.out.println("\n****Delete the existing node****\n");
      System.out.println("Delete from beginning");
      list2.deleteFromStart();
      list2.printList();
//      if (list2.find("1") == null) {
//        System.out.println("deleted 1st node from the list!");
//      }
      System.out.println("Delete from index 1");
      list2.deleteFromIndex(1);
      list2.printList();
//      if (list1.find("show2") == null) {
//        System.out.println("delete operation is done with specific index!");
//      }

    } catch (Exception e) {
      e.printStackTrace();
    } finally {

        sc.close();

    }
  }
}

///////////////////////////////////////////////////////////////////


/**
 * This a an interface which contains a method declaration for comparing the two Teams. This needs
 * to be implemented by the Team class.
 */

///////////////////////////////////////////////////////////////////

class Team implements Groupable, Cloneable {
  private String teamID;
  private String teamName;
  private String groupName;
  private int gamesPlayed;
  private int gamesWon;
  private int gamesLost;
  private double netRunRate;
  private int points;
  private boolean ArrayList;
  private boolean teamGuide;

  	/**
	 * This is parameterized constructor
	 * 
	 * @param teamID      of the team
	 * @param teamName    of the team
	 * @param groupName   of the team
	 * @param gamesPlayed for the team
	 * @param gamesWon    for the team
	 * @param gamesLost   for the team
	 * @param netRunRate  of the team
	 * @param points      for the team
	 */
  public Team(
          String teamID,
          String teamName,
          String groupName,
          int gamesPlayed,
          int gamesWon,
          int gamesLost,
          double netRunRate,
          int points) {
    this.teamID = teamID;
    this.teamName = teamName;
    this.groupName = groupName;
    this.gamesPlayed = gamesPlayed;
    this.gamesWon = gamesWon;
    this.gamesLost = gamesLost;
    this.netRunRate = netRunRate;
    this.points = points;
  }

  	/**
	 * This is a copy constructor
	 * 
	 * 
	 */

	// @param object team of class Team
//	 * @param ID     of the team
  public Team(Team team, String ID) {
    this(
        ID,
        team.teamName,
        team.groupName,
        team.gamesPlayed,
        team.gamesWon,
        team.gamesLost,
        team.netRunRate,
        team.points);
  }

  /**
   * mutator method to set teamID
   *
   * @param teamID for team id
   */
  public void setTeamID(String teamID) {
    this.teamID = teamID;
  }

  /**
   * accessor method to get teamID
   *
   * @return teamiD
   */
  public String getTeamID() {
    return teamID;
  }

  /**
   * mutator method to set teamName
   *
   * @param teamName for team name
   */
  public void setTeamName(String teamName) {
    this.teamName = teamName;
  }

  /**
   * accessor method to get teamName
   *
   * @return teamName
   */
  public String getTeamName() {
    return teamName;
  }

  /**
   * mutator method to set gamesPlayed
   *
   * @param gamesPlayed for a team
   */
  public void setGamesPlayed(int gamesPlayed) {
    this.gamesPlayed = gamesPlayed;
  }

  /**
   * accessor method to get gamesPlayed
   *
   * @return gamesPlayed
   */
  public int getGamesPlayed() {
    return gamesPlayed;
  }

  /**
   * mutator method to set gamesWon
   *
   * @param gamesWon for a team
   */
  public void setGamesWon(int gamesWon) {
    this.gamesWon = gamesWon;
  }

  /**
   * accessor method to get gamesWon
   *
   * @return gamesWon
   */
  public int getGamesWon() {
    return gamesWon;
  }

  /**
   * mutator method to set gamesLost
   *
   * @param gamesLost for a team
   */
  public void setGamesLost(int gamesLost) {
    this.gamesLost = gamesLost;
  }

  /**
   * accessor method to get gamesLost
   *
   * @return gamesLost
   */
  public int getGamesLost() {
    return gamesLost;
  }

  /**
   * mutator method to set netRunRate
   *
   * @param netRunRate for a team
   */
  public void setNetRunRate(double netRunRate) {
    this.netRunRate = netRunRate;
  }

  /**
   * accessor method to get netRunRate
   *
   * @return netRunRate
   */
  public double getNetRunRate() {
    return netRunRate;
  }

  /**
   * mutator method to set points
   *
   * @param points for a team
   */
  public void setPoints(int points) {
    this.points = points;
  }

  /**
   * accessor method to get points
   *
   * @return points
   */
  public int getPoints() {
    return points;
  }

  /**
   * Clone method to create an object of class Team.
   *
   * @return the copy of the called Team object with user entered teamID.
   */
  @Override
  public Object clone() {
    System.out.println("Enter the teamID for a new Team:");
    Scanner sc = new Scanner(System.in);
    String id = sc.nextLine();
    sc.close();
    Team team = null;
    try {
      if (!id.equals(teamID)) {
        team = (Team) super.clone();
        team.setTeamID(id);
      } else {
        throw new SameTeamIDFound("The given teamID is already assigned to other team!!");
      }
    } catch (SameTeamIDFound e) {
      System.out.println(e);
    } catch (CloneNotSupportedException e) {
      team =
          new Team(
              id,
              this.teamName,
              this.groupName,
              this.gamesPlayed,
              this.gamesWon,
              this.gamesLost,
              this.netRunRate,
              this.points);
    }
    return team;
  }

  /**
   * The method equals() for checking whether two objects are equal or not
   *
   * @param obj Object
   * @return true is both are equal, otherwise false
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Team team = (Team) obj;
    try {
      if (teamID.equals(team.getTeamID())) {
        throw new SameTeamIDFound("The teamIDs of two teams can not be same.");
      }
    } catch (SameTeamIDFound e) {
      System.out.println(e);
    }
    if (Integer.compare(team.gamesPlayed, gamesPlayed) != 0) {
      return false;
    }
    if (Integer.compare(team.gamesWon, gamesWon) != 0) {
      return false;
    }
    if (Integer.compare(team.gamesLost, gamesLost) != 0) {
      return false;
    }
    if (Double.compare(team.netRunRate, netRunRate) != 0) {
      return false;
    }
    if (Integer.compare(team.points, points) != 0) {
      return false;
    }
    return Objects.equals(teamName, team.teamName);
  }

  /**
   * toString() method is overrided.
   *
   * @return String
   */
  @Override
  public String toString() {
    return "Team{"
        + "teamID="
        + teamID
        + " teamName="
        + teamName
        + '\''
        + ", gamesPlayed="
        + gamesPlayed
        + ", gamesWon="
        + gamesWon
        + ", gamesLost="
        + gamesLost
        + ", netRunRate="
        + netRunRate
        + ", points="
        + points
        + '}';
  }

  /**
   * This method is implemented from the Groupable interface.
   *
   * @param T Team object
   * @return String
   */
  @Override
  public boolean isInTheGroup(Team T) {
    if (this.groupName == T.groupName) {
      return true;
    } else {
      return false;
    }
  }
} // end of class Team

/////////////////////////////////////////////////////////////////

/** This class generates the connected list of Teams. */
class TeamList implements Cloneable {

  /** This is the inner class for creating the nodes for Teams */
  // privacy leak because we need to keep TeamNode class as public to create the
  // object of it.
  // as it is public there is a privacy leak.
  public static class TeamNode implements Cloneable {
    private Team team;
    private TeamNode teamNode;

    /** Default constructor */
    public TeamNode() {
      this.team = null;
      this.teamNode = null;
    }

    /**
     * This is parameterized constructor
     *
     * @param team Team object
     * @param teamNode TeamNode object
     */
    public TeamNode(Team team, TeamNode teamNode) {
      this.team = team;
      this.teamNode = teamNode;
    }

    /**
     * Copy Constructor
     *
     * @param node TeamNode object
     */
    public TeamNode(TeamNode node) {
      this(node.team, node.teamNode);
      //            this.team=new Team (node.team,node.team.getTeamID());
      //            this.teamNode=new TeamNode(node.teamNode);
    }

    /**
     * This is a overrided version of clone method.
     *
     * @return object of TeamNode
     */
    @Override
    public Object clone() {
      TeamNode node = null;
      try {
        node = (TeamNode) super.clone();
        node.team = new Team(node.team, node.team.getTeamID());
        node.teamNode = new TeamNode(node.teamNode);
      } catch (CloneNotSupportedException e) {
        node = new TeamNode(this.team, this.teamNode);
      }
      return node;
    }

    /**
     * Mutator method for assigning the teamNode to the current node
     *
     * @param teamNode TeamNode object
     */
    public void setTeamNode(TeamNode teamNode) {
      this.teamNode = teamNode;
    }

    /**
     * accessor method for getting teamNode object
     *
     * @return TeamNode object
     */
    public TeamNode getTeamNode() {
      return teamNode;
    }

    /**
     * Mutator method for assigning team to the current node
     *
     * @param team Team object
     */
    public void setTeam(Team team) {
      this.team = team;
    }

    /**
     * Accessor method for getting team present in the current node.
     *
     * @return Team object
     */
    public Team getTeam() {
      return team;
    }
  } // end of TeamNode class

  private TeamNode head;
  private int size;

  /** Default constructor */
  public TeamList() {
    head = null;
    size = 0;
  }

  /**
   * Copy constructor
   *
   * @param teamList TeamList object
   */
  public TeamList(TeamList teamList) {
    this.head = (TeamNode) teamList.head.clone();
    this.size = teamList.size;
  }

  /**
   * Accessor method for getting the head node of the current TeamList
   *
   * @return head of the list
   */
  public TeamNode getHead() {
    return head;
  }

  /**
   * This method add the new node in the beginning of the TeamList
   *
   * @param team object of Team class
   */
  public void addToStart(Team team) {
    if (head == null) {
      head = new TeamNode(team, null);
    } else {
      TeamNode node = new TeamNode(team, head);
      head = node;
    }
    size++;
  }

  /**
   * This method add the new node at the given index in the list.
   *
   * @param team object of Teamclass
   * @param index where the node needs to be add
   */
  public void insertAtIndex(Team team, int index) {
    try {
      if (index >= 0 && index <= size - 1) {
        if (index == 0) {
          TeamNode node = new TeamNode(team, head);
          head = node;
        } else {
          TeamNode current = head;
          TeamNode previous = null;
          while (index != 0) {
            previous = current;
            current = current.teamNode;
            index--;
          }
          TeamNode node = new TeamNode(team, current);
          previous.teamNode = node;
        }
        size++;
      } else {
        throw new NoSuchElementException("The index number is not valid!!");
      }
    } catch (NoSuchElementException e) {
      System.out.println(e);
    }
  }

  /**
   * This method removes the node indexed by the given index.
   *
   * @param index gives the index number of the node in the list to be deleted
   */
  public void deleteFromIndex(int index) {
    try {
      if (index >= 0 && index <= size - 1) {
        TeamNode current = head;
        TeamNode previous = null;
        if (index == 0) {
          head = current.teamNode;
        } else {
          while (index != 0) {
            previous = current;
            current = current.teamNode;
            index--;
          }
          previous.teamNode = current.teamNode;
        }
        size--;
      } else {
        throw new NoSuchElementException("The index number is not valid!!");
      }
    } catch (NoSuchElementException e) {
      System.out.println(e);
    }
  }

  /** This method removes the node from the beginning of the list. */
  public void deleteFromStart() {
    if (head == null) {
      return;
    } else {
      TeamNode temp = head;
      head = head.teamNode;
      temp.teamNode = null;
      size--;
    }
  }

  /**
   * This method replace a team object from the TeamList with the new team.
   *
   * @param team object of class Team by which a team will be replaced.
   * @param index gives the index number in the TeamList.
   */
  public void replaceAtIndex(Team team, int index) {
    if (index >= 0 && index <= size - 1) {
      TeamNode current = head;
      while (index != 0) {
        current = current.teamNode;
        index--;
      }
      current.setTeam(team);
    } else {
      return;
    }
  }

  /**
   * This method gives the object of TeamNode for a given TeamID from the list.
   *
   * @param teamID of type String
   * @return a pointer to an object of type TeamNode
   */
  public TeamNode find(String teamID) {
    int iterations = 0;
    if (head == null) {
      return null;
    }
    TeamNode temp = head;
    while (temp != null) {
      iterations++;
      String id = temp.getTeam().getTeamID();
      if (id.equals(teamID)) {
        System.out.println("teamID: " + teamID + " FOUND with " + iterations + " iterations");
        return temp;
      }
      temp = temp.teamNode;
    }
	// System.out.println("teamID: " + teamID + " is not in the list ");
    return null;
  }

	/**
	 * This method makes the list of Teams which move to the next round or not.
	 * 
	 * @param teamName of type String
	 * @return a pointer to an object of type boolean
	 */

  public boolean findShowWithName(String teamName) {

    if (head == null) {
      return false;
    }
    TeamNode temp = head;
    while (temp != null) {
      String name = temp.getTeam().getTeamName();
      if (teamName.equals(name)) {
        return true;
      }
      temp = temp.teamNode;
    }
	// System.out.println("Not in the list");
    return false;
  }


  /**
   * This method checks whether a given TeamID is present in the list or not.
   *
   * @param teamID String of TeamID
   * @return true if list contains the given ID, otherwise false
   */
  public boolean contains(String teamID) {
    int iterations = 0;
    if (head == null) {
      //System.out.println("teamID: " + teamID + " NOT FOUND");
      return false;
    }
    TeamNode temp = head;
    while (temp != null) {
      iterations++;
      if (temp.getTeam().getTeamID().equals(teamID)) {
        System.out.println("teamID: " + teamID + " FOUND with " + iterations + " iterations");
        return true;
      }
      temp = temp.teamNode;
    }
    //System.out.println("teamID: " + teamID + " NOT FOUND");
    return false;
  }

	/**
	 * This method is for finding list of Teams which move to the next round or not.
	 * 
	 * @param s of type String
	 */

  public void findIfQualified(String s) {
		// System.out.println("Testing its qualification");
    TeamNode temp = head;
    Team team = null;
    int max_points = temp.getTeam().getPoints();
    int second_max = 0;
    int max_times = 1;
    while (temp != null) {
      if (temp.getTeam().getTeamName().equals(s)) {
        team = temp.getTeam();
      }
      if (max_points <= temp.getTeam().getPoints()) {
        if (max_points == temp.getTeam().getPoints()) {
          max_times++;
        } else {
          second_max = max_points;
          max_points = temp.getTeam().getPoints();
          max_times = 1;
        }
      }
      temp = temp.teamNode;
    }
    if(team.getPoints() == max_points){
      if(max_times <= 2){
			System.out.println(
					team.getTeamName() + " qualifies for second round as it has more points then four other teams");
      }
      else{
        temp = head;
        int higher= 0;
        while(temp!=null){
          if(temp.getTeam().getNetRunRate()> team.getNetRunRate()
                  && temp.getTeam().getPoints() == max_points &&
          !(temp.getTeam().getTeamID().equals(team.getTeamID()))){
            higher++;
          }
			if (higher >= 2) {
				System.out.println(team.getTeamName()
						+ " does not qualify for second round as it does not have high enough run rate");
            break;
          }
          temp = temp.teamNode;
        }
        if(higher<2){
			System.out.println(team.getTeamName() + " qualifies for second round as it has higher run rate");
        }
      }
    }
    else if(team.getPoints() == second_max){
      if (max_times>=2){
			System.out.println(
					team.getTeamName() + " does not qualify for second round as it does not have enough points");
      }
      else{
        temp = head;
        int higher= 0;
        while(temp!=null){
          if(temp.getTeam().getNetRunRate()> team.getNetRunRate()
                  && (temp.getTeam().getPoints() == second_max)
                  && !(temp.getTeam().getTeamID().equals(team.getTeamID()))){
				System.out.println(team.getTeamName()
						+ " does not qualify for second round as it does not have high enough run rate");
            higher++;
            break;
          }
          temp = temp.teamNode;
        }
        if(higher<1) {
			System.out.println(team.getTeamName()
					+ " qualifies for second round as it has high more points then four other teams");
		}
        }
      }
    else {
		System.out.println(team.getTeamName() + " does not qualify for second round as it does not have enough points");
    }
  }


  /**
   * This is a overrided version of the equals method
   *
   * @param obj object of TeamList class
   * @return true if both list are equal, otherwise false
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    } else {
      TeamList teamList = (TeamList) obj;
      if (size != teamList.size) {
        return false;
      }
      TeamNode head1 = head;
      TeamNode head2 = teamList.head;
      while (head1 != null) {
        if (!head1.getTeam().equals(head2.getTeam())) {
          return false;
        }
        head1 = head1.teamNode;
        head2 = head2.teamNode;
      }
      return true;
    }
  }

  /** This method prints the TeamList. */

  public void printList() {
    TeamNode temp = head;
	while (temp.teamNode != null) {
      System.out.print(temp.getTeam().getTeamID()+":"+temp.getTeam().getTeamName() + " --> ");
      temp = temp.teamNode;
    }
	//

	System.out.print(temp.getTeam().getTeamID() + ":" + temp.getTeam().getTeamName() + "\n");
  }
}

/* end of TeamList class */

//Group A
//England 5 4 1 +2.464 8
//Australia 5 4 1 +1.216 8
//South_Africa 5 4 1 +0.739 8
//Sri_Lanka 5 2 3 -0.269 4
//West_Indies 5 1 4 -1.641 2
//Bangladesh 5 0 5 -2.383 0
//
//Group B
//Pakistan 5 5 0 +1.583 10
//New_Zealand 5 4 1 +1.162 8
//India 5 3 2 +1.747 6
//Afghanistan 5 2 3 +1.053 4
//Namibia 5 1 4 -1.890 2
//Scotland 5 0 5 -3.543 0
//
//
//
//requests
//Australia
//New_Zealand
//Namibia
//South_Africa
