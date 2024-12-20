Feature: CreateDirectory

  Scenario Outline: Validate that directory is created and files are created inside the directory
    Given I created a directory <dirName> in my home directory

    Examples: 
      | dirName |
      | test1   |

  Scenario Outline: Create files inside the directory
    Given I create files <fileName> in <dirName>

    Examples: 
      | fileName | dirName |
      | auto1    | test1   |
      | auto2    | test1   |
      | auto3    | test1   |
      | auto4    | test1   |
      | auto5    | test1   |

  Scenario Outline: Validate that files are created inside the directory
    Given list all the files in <dirName>

    Examples: 
      | dirName |
      | test1   |

  Scenario Outline: Putting all contents to new file
    Given Put contents of all file in <dirName> to <destDirName>
    And Download the new file in local machine and display its content

    Examples: 
      | dirName | destDirName | 
      | test1   | copyContent | 
