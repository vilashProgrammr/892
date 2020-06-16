#!/usr/bin/env bash
echo "Executing the test.."
cat Echo.java|tr '\n' '\r'| sed 's/.*\/\/\/{\(.*\)\/\/\/}.*/\1/'|tr '\r' '\n' > user_code

:> .testcaseop2 && javac -classpath './:./junit-4.10.jar' Echo.java && java -classpath './:./junit-4.10.jar' Echo_JUNIT  user_code > .testcaseop2

if grep -q 'error: ' .testcaseop2; then
   echo "SYNTAXERROR"
else if grep -q 'Great job' .testcaseop2; then
   echo "SUCCESS"
else if grep -q 'Uh-oh' .testcaseop2; then
   echo "TESTCASEFAILED"
else
   echo "UNKNOWNERROR"    
fi
fi
fi
echo ""
echo "!done!"
