DIR = ru/jolly/ray
TARGET = Main
SRC = src
DST = dst

all: clear
	@javac -d $(DST) -cp $(SRC) $(SRC)/$(DIR)/$(TARGET).java
	@java -cp $(DST) $(DIR)/$(TARGET)

clear:
	@rm -rf $(DST)/*