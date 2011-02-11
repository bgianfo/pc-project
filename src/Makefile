############################################################
#
# Author: Brian Gianforcaro - b.gianfo@gmail.com
#
############################################################
EX = java
CC = javac -Xlint:all
PJ = ../pj.jar:.

default: class

run: class
	$(EX) -cp $(PJ) Matrix
	$(EX) -cp $(PJ) MatrixOp
	$(EX) -cp $(PJ) MatrixParallelOp

class: clean *.java
	$(CC) -cp $(PJ) *.java
   
zip: bundle
bundle:
	zip matrix.zip *.java Makefile

clean:
	@clear
	@rm -rf *.class
	@rm -rf *.zip

