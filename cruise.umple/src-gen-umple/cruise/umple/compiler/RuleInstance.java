/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/

package cruise.umple.compiler;
import java.util.*;

/**
 * @umplesource Parser.ump 198
 * @umplesource Parser_Code.ump 1359
 */
// line 198 "../../../../src/Parser.ump"
// line 1359 "../../../../src/Parser_Code.ump"
public class RuleInstance
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //RuleInstance Attributes
  private List<String> stopAts;
  private int updateIndex;
  private int rulePartsIndex;

  //RuleInstance Associations
  private List<RulePart> ruleParts;
  private Parser parser;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public RuleInstance(Parser aParser)
  {
    stopAts = new ArrayList<String>();
    updateIndex = -1;
    rulePartsIndex = 0;
    ruleParts = new ArrayList<RulePart>();
    if (!setParser(aParser))
    {
      throw new RuntimeException("Unable to create RuleInstance due to aParser");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean addStopAt(String aStopAt)
  {
    boolean wasAdded = false;
    wasAdded = stopAts.add(aStopAt);
    return wasAdded;
  }

  public boolean removeStopAt(String aStopAt)
  {
    boolean wasRemoved = false;
    wasRemoved = stopAts.remove(aStopAt);
    return wasRemoved;
  }

  public String getStopAt(int index)
  {
    String aStopAt = stopAts.get(index);
    return aStopAt;
  }

  public String[] getStopAts()
  {
    String[] newStopAts = stopAts.toArray(new String[stopAts.size()]);
    return newStopAts;
  }

  public int numberOfStopAts()
  {
    int number = stopAts.size();
    return number;
  }

  public boolean hasStopAts()
  {
    boolean has = stopAts.size() > 0;
    return has;
  }

  public int indexOfStopAt(String aStopAt)
  {
    int index = stopAts.indexOf(aStopAt);
    return index;
  }

  public RulePart getRulePart(int index)
  {
    RulePart aRulePart = ruleParts.get(index);
    return aRulePart;
  }

  public List<RulePart> getRuleParts()
  {
    List<RulePart> newRuleParts = Collections.unmodifiableList(ruleParts);
    return newRuleParts;
  }

  public int numberOfRuleParts()
  {
    int number = ruleParts.size();
    return number;
  }

  public boolean hasRuleParts()
  {
    boolean has = ruleParts.size() > 0;
    return has;
  }

  public int indexOfRulePart(RulePart aRulePart)
  {
    int index = ruleParts.indexOf(aRulePart);
    return index;
  }

  public Parser getParser()
  {
    return parser;
  }

  public static int minimumNumberOfRuleParts()
  {
    return 0;
  }

  public boolean addRulePart(RulePart aRulePart)
  {
    boolean wasAdded = false;
    if (ruleParts.contains(aRulePart)) { return false; }
    ruleParts.add(aRulePart);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeRulePart(RulePart aRulePart)
  {
    boolean wasRemoved = false;
    if (ruleParts.contains(aRulePart))
    {
      ruleParts.remove(aRulePart);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addRulePartAt(RulePart aRulePart, int index)
  {  
    boolean wasAdded = false;
    if(addRulePart(aRulePart))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfRuleParts()) { index = numberOfRuleParts() - 1; }
      ruleParts.remove(aRulePart);
      ruleParts.add(index, aRulePart);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveRulePartAt(RulePart aRulePart, int index)
  {
    boolean wasAdded = false;
    if(ruleParts.contains(aRulePart))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfRuleParts()) { index = numberOfRuleParts() - 1; }
      ruleParts.remove(aRulePart);
      ruleParts.add(index, aRulePart);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addRulePartAt(aRulePart, index);
    }
    return wasAdded;
  }

  public boolean setParser(Parser newParser)
  {
    boolean wasSet = false;
    if (newParser != null)
    {
      parser = newParser;
      wasSet = true;
    }
    return wasSet;
  }

  public void delete()
  {
    ruleParts.clear();
    parser = null;
  }


  public String toString()
  {
	  String outputString = "";
	  
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "parser" + "=" + getParser() != null ? !getParser() .equals(this)  ? getParser().toString().replaceAll("  ","    ") : "this" : "null"
     + outputString;
  }  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 1362 ../../../../src/Parser_Code.ump
  public void configureDefinition(String definition, String... allStopAts)
  {
    stopAts.clear();
    for(String stopAt : allStopAts)
    {
      stopAts.add(stopAt);
    }
    TextParser ruleParser = new TextParser(definition);
    while (ruleParser.next() != null)
    {
      String currentRule = ruleParser.name();
      RulePart currentPart = analyzeRule(currentRule);
      addRulePart(currentPart);
    }
    updateNextIdentifier();
  }

  public boolean hasMoreRuleParts()
  {
    return rulePartsIndex < ruleParts.size();
  }

  public void resetRulePart()
  {
    rulePartsIndex = 0;
  }

  public RulePart nextRulePart()
  {
    if (rulePartsIndex >= numberOfRuleParts() || rulePartsIndex < 0)
    {
      return new RulePart(null,null);
    }
    return getRulePart(rulePartsIndex++);
  }

  public boolean nextCombination()
  {
    if (updateIndex == -1)
    {
      updateIndex = 0;
      return true;
    }

    boolean didChange = false;
    while (updateIndex < ruleParts.size() - 1)
    {
      RulePart part = ruleParts.get(updateIndex);
      if (part.isOptional())
      {
        ruleParts.remove(updateIndex);
        didChange = true;
        break;
      }
      else
      {
        updateIndex++;
      }
    }
    return didChange;
  }

  public void updateNextIdentifier()
  {
    for (int i = 0; i < numberOfRuleParts(); i++)
    {
      updateNextPart(i);
    }
  }

  private void updateNextPart(int i)
  {
    RulePart currentPart = getRulePart(i);
    currentPart.removeNextIdentifiers();
    int lastIndex = numberOfRuleParts() - 1;

    if (i == lastIndex)
    {
      updateLastNextPart(currentPart);
      return;
    }

    if (currentPart.isRule() && currentPart.isMany())
    {
      Rule r = parser.getRule(currentPart.getName());

      if (r.numberOfDefinitions() > 0)
      {
        TextParser textParser = new TextParser(r.getDefinition(0));
        RulePart ruleFirstPart = analyzeRule(textParser.next());
        addNextIdentifierFor(currentPart,ruleFirstPart);
      }
    }

    int nextPartOffset = 1;
    RulePart nextPart = getRulePart(i + nextPartOffset);

    if (nextPart.isMany() && (i + nextPartOffset) == lastIndex)
    {
      updateLastNextPart(currentPart);
    }

    while (nextPart.isRule())
    {

      Rule r = parser.getRule(nextPart.getName());

      boolean keepTrying = false;
      while (r != null)
      {
        for (String definition : r.getDefinitions())
        {
          TextParser textParser = new TextParser(definition);
          RulePart ruleFirstPart = analyzeRule(textParser.next());


          if (ruleFirstPart.isRule())
          {
            r = parser.getRule(ruleFirstPart.getName());
            keepTrying = true;
            break;
          }
          else
          {
            addNextIdentifierFor(currentPart,ruleFirstPart);
          }
        }

        if (keepTrying)
        {
          keepTrying = false;
        }
        else
        {
          r = null;
        }
      }

      nextPartOffset++;
      if ( (i+nextPartOffset) < ruleParts.size() && (nextPart.isOptional() || nextPart.isMany()) && !currentPart.isMany())
      {
        nextPart = getRulePart(i + nextPartOffset);
      }
      else
      {
        nextPart = new RulePart(null,null);
      }
    }

    if (!nextPart.isRule())
    {
      addNextIdentifierFor(currentPart,nextPart);
    }
  }

  private void updateLastNextPart(RulePart part)
  {
    for (String stop : stopAts)
    {
      part.addNextIdentifier(stop);
    }
  }

  public boolean removeOptionalPart()
  {
    for (int i=0; i<numberOfRuleParts(); i++)
    {
      RulePart part = getRulePart(i);
      if (part.isOptional() && part.isVariable() && !part.isEnum())
      {
        removeRulePart(part);
        return true;
      }
    }
    return false;
  }

  private void addNextIdentifierFor(RulePart currentPart, RulePart nextPart)
  {
    if (nextPart.isStatic())
    {
      currentPart.addNextIdentifier(nextPart.getName());
    }
    else if (nextPart.isEnum())
    {
      for(String aName : nextPart.getEnums())
      {
        currentPart.addNextIdentifier(aName);
      }
    }
  }

  private RulePart analyzeRule(String input)
  {
    RulePart part = new RulePart(input, null);

    if (input == null)
    {
      return part;
    }

    if (input.endsWith("*") || input.endsWith("?"))
    {
      String multiplicity = input.substring(input.length() - 1);
      part.setMultiplicity(multiplicity);
      input = input.substring(0, input.length() - 1);
    }

    if (input.startsWith("[[") && input.endsWith("]]"))
    {
      part.setName(input.substring(2, input.length() - 2));
      part.setType(RulePart.Type.Rule);
    }
    else if (input.startsWith("[") && input.endsWith("]"))
    {
      part.setName(input.substring(1, input.length() - 1));
      part.setType(RulePart.Type.Variable);
    }

    return part;
  }
}