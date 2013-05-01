/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.patterns.test;

// line 12 "../../../../src/TestHarnessPatternsImmutable.ump"
public class WidgetImmutableB
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //WidgetImmutableB Attributes
  private String name;

  //Helper Variables
  private boolean canSetName;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public WidgetImmutableB(String aName)
  {
    name = aName;
    canSetName = false;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public String getName()
  {
    return name;
  }

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
	  
    return super.toString() + "["+
            "name" + ":" + getName()+ "]"
     + outputString;
  }
}