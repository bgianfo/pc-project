############################################################
#
# Author: Brian Gianforcaro - b.gianfo@gmail.com
#
############################################################
CC = /usr/local/versions/jdk-1.5.0_15/bin/javac -Xlint:all
EX = /usr/local/versions/jdk-1.5.0_15/bin/java
PJ = ../pj.jar:.

default: class

run: class
	$(EX) -cp $(PJ) Matrix
	$(EX) -cp $(PJ) MatrixOp
	$(EX) -cp $(PJ) MatrixParallelOp

class: *.java
	$(CC) -cp $(PJ) *.java
   

test: class
	$(EX) -Xmx3g -Dpj.nt=1 Tester
	$(EX) -Xmx3g -Dpj.nt=2 Tester
	$(EX) -Xmx3g -Dpj.nt=4 Tester
	$(EX) -Xmx3g -Dpj.nt=7 Tester
	$(EX) -Xmx3g -Dpj.nt=8 Tester

test-inversion: class
	$(EX) -Xmx3g -Dpj.nt=1 TesterInverse
	$(EX) -Xmx3g -Dpj.nt=2 TesterInverse
	$(EX) -Xmx3g -Dpj.nt=4 TesterInverse
	$(EX) -Xmx3g -Dpj.nt=7 TesterInverse
	$(EX) -Xmx3g -Dpj.nt=8 TesterInverse


zip: bundle
bundle:
	zip matrix.zip *.java Makefile

clean:
	@clear
	@rm -rf *.class
	@rm -rf *.zip

