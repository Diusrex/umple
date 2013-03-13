/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/

package cruise.umple.compiler;
import cruise.umple.compiler.Position;

/**
 * @umplesource StateMachine.ump 151
 */
// line 151 "../../../../src/StateMachine.ump"
public class Guard
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Guard Attributes
  private Position position;
  private String condition;
  private CodeBlock codeblock;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetCondition;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Guard(String aCondition)
  {
    cachedHashCode = -1;
    canSetCondition = true;
    condition = aCondition;
    codeblock = null;
    // line 159 "../../../../src/StateMachine.ump"
    codeblock = aCondition!=null ? new CodeBlock(aCondition) : new CodeBlock();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setPosition(Position aPosition)
  {
    boolean wasSet = false;
    position = aPosition;
    wasSet = true;
    return wasSet;
  }

  public boolean setCondition(String aCondition)
  {
    boolean wasSet = false;
    // line 160 "../../../../src/StateMachine.ump"
    codeblock.setCode(aCondition);
    if (!canSetCondition) { return false; }
    condition = aCondition;
    wasSet = true;
    return wasSet;
  }

  public boolean setCodeblock(CodeBlock aCodeblock)
  {
    boolean wasSet = false;
    codeblock = aCodeblock;
    wasSet = true;
    // line 167 "../../../../src/StateMachine.ump"
    if(condition!=null){
      	  condition+= aCodeblock.getCode();
      	}
      	else
      	  condition = aCodeblock.getCode();
    return wasSet;
  }

  public Position getPosition()
  {
    return position;
  }

  public String getCondition()
  {
    String aCondition = condition;
    // line 161 "../../../../src/StateMachine.ump"
    if (codeblock.getCode()!=null)
      	  return codeblock.getCode();
      	  else
    return aCondition;
  }

  /**
   * target language code
   */
  public CodeBlock getCodeblock()
  {
    return codeblock;
  }

  public boolean equals(Object obj)
  {
    if (obj == null) { return false; }
    if (!getClass().equals(obj.getClass())) { return false; }

    Guard compareTo = (Guard)obj;
  
    if (condition == null && compareTo.condition != null)
    {
      return false;
    }
    else if (condition != null && !condition.equals(compareTo.condition))
    {
      return false;
    }

    return true;
  }

  public int hashCode()
  {
    if (cachedHashCode != -1)
    {
      return cachedHashCode;
    }
    cachedHashCode = 17;
    if (condition != null)
    {
      cachedHashCode = cachedHashCode * 23 + condition.hashCode();
    }
    else
    {
      cachedHashCode = cachedHashCode * 23;
    }

    canSetCondition = false;
    return cachedHashCode;
  }

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
	  
    return super.toString() + "["+
            "condition" + ":" + getCondition()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "position" + "=" + getPosition() != null ? !getPosition() .equals(this)  ? getPosition().toString().replaceAll("  ","    ") : "this" : "null" + System.getProperties().getProperty("line.separator") +
            "  " + "codeblock" + "=" + getCodeblock() != null ? !getCodeblock() .equals(this)  ? getCodeblock().toString().replaceAll("  ","    ") : "this" : "null"
     + outputString;
  }
}