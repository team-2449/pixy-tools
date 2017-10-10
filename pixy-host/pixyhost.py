from pixy import *
from ctypes import *
from networktables import NetworkTables

##CONFIGURATION VARIABLES##
serveraddress='localhost'  ##DEFAULT:"RoboRIO-FRC-xxxx.local"
tablename='pixy-table'

print ("Pixy NetworkTables Interface from Out of Orbit Robotics, Team 2449")
print ("Adapted from get_blocks.py in pixy/build/libpixyusb_swig")

pixy_init()

class Blocks (Structure):
	_fields_ = [ ("type", c_uint),
               ("signature", c_uint),
               ("x", c_uint),
               ("y", c_uint),
               ("width", c_uint),
               ("height", c_uint),
               ("angle", c_uint) ]

blocks = BlockArray(100)
frame  = 0


NetworkTables.setClientMode()
NetworkTables.initialize(server=serveraddress)
table=NetworkTables.getTable(tablename)

while 1:
	count = pixy_get_blocks(100, blocks)
	print count
	if count > 0:
    		print 'frame %3d:' % (frame)
    		frame = frame + 1
    		for index in range (0, count):
			print '[BLOCK_TYPE=%d SIG=%d X=%3d Y=%3d WIDTH=%3d HEIGHT=%3d]' % (blocks[index].type, blocks[index].signature, blocks[index].x, blocks[index].y, blocks[index].width, blocks[index].height)
			table.putNumber('BLOCK_TYPE',blocks[index].type)
			table.putNumber('SIG',blocks[index].signature)
			table.putNumber('X',blocks[index].x)
			table.putNumber('Y',blocks[index].y)
			table.putNumber('WIDTH',blocks[index].width)
			table.putNumber('HEIGHT',blocks[index].height)
