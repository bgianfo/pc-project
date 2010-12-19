############################################################
#
# Author: Brian Gianforcaro - b.gianfo@gmail.com
#
############################################################
EX = java
CC = javac -Xlint:all
PJ = ../pj.jar:.

TARGET = PrimeTesterSmp

default: class

run: class
	$(EX) -cp $(PJ) $(TARGET)

class: clean *.java
	$(CC) -cp $(PJ) *.java
   
zip: bundle

bundle:
	zip hw1.zip hw1-1.txt hw1-2.txt ElementaryCASeq.java ElementaryCASmp.java hw1-3.txt
clean:
	rm -rf *.class
	rm -rf *.zip

