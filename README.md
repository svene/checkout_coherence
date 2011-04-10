Examples from the Coherence Tutorial/Documentation
===================================================
available
from [c1]: http://download.oracle.com/docs/cd/E15357_01/coh.360/e15831/toc.htm

# Prerequisites:
  1. Download the Coherence-zip from here: [c2]: http://www.oracle.com/technetwork/middleware/coherence/downloads/index.html
  2. Unzip it, set an environmont variable COHERENCE_HOME to the folder you unzipped Coherence.
  3. Remove the COHERENCE_HOME assignments from COHERENCE_HOME/bin/coherence.[sh|cmd]
  from and COHERENCE_HOME/bin/cache-server.[sh|cmd]
  4. Verify installation as described in first chapter of the tutorial:
  http://download.oracle.com/docs/cd/E15357_01/coh.360/e15831/installcoh.htm#sthref10
  5. Checkout the examples from this github project

## Preparation of examples:
1. Create a folder named '0_localrepository' in the projects root folder.
2. Copy 'COHERENCE_HOME/lib/coherence.jar' to '0_localrepository'
3. Build the project (which runs the  tests as well):
   unix: ./gradlew build
   windows: gradlew build
   
