# programmer: Sakshyam Dahal
# Date : October 22, 2014

# strassens method for matrix multiplication

def strassenMethod(matrixA, matrixB):
	n = len(matrixA)
	result = [[0 for x in xrange(n)] for x in xrange(n)]

	# when n != 2^k we find the nearest power of two and then 
	# pad the original matrix with 0's so that we get the
	# new order which is some power of 2 and then we apply
	# strassens algorithm

	if (not powerOfTwo(n)) and n != 1:
		newOrder = nearestPowerOfTwo(n)
		matrixA1 = [[0 for x in xrange(newOrder)] for x in xrange(newOrder)]
		matrixB1 = [[0 for x in xrange(newOrder)] for x in xrange(newOrder)]
		for i in xrange(0, n):
			for j in xrange(0,n):
				matrixA1[i][j] = matrixA[i][j]
				matrixB1[i][j] = matrixB[i][j]

		newResult = strassenMethod(matrixA1, matrixB1)
		for i in xrange(0, n):
			for j in xrange(0,n):
				result[i][j] = newResult[i][j]

		return result

	# base case
	elif n == 1:
		result[0][0] = matrixA[0][0] * matrixB[0][0]
		return result

	# real algorithm
	else:
		# divide each matrix into 4 halves
		A11 = [[0 for x in xrange(n/2)] for x in xrange(n/2)]
		A12 = [[0 for x in xrange(n/2)] for x in xrange(n/2)]
		A21 = [[0 for x in xrange(n/2)] for x in xrange(n/2)]
		A22 = [[0 for x in xrange(n/2)] for x in xrange(n/2)]
		B11 = [[0 for x in xrange(n/2)] for x in xrange(n/2)]
		B12 = [[0 for x in xrange(n/2)] for x in xrange(n/2)]
		B21 = [[0 for x in xrange(n/2)] for x in xrange(n/2)]
		B22 = [[0 for x in xrange(n/2)] for x in xrange(n/2)]
		
		divideMatrix(matrixA, A11, 0 , 0)  
		divideMatrix(matrixA, A12, 0 , n/2) 
		divideMatrix(matrixA, A21, n/2, 0)   
		divideMatrix(matrixA, A22, n/2, n/2)
		divideMatrix(matrixB, B11, 0 , 0)  
		divideMatrix(matrixB, B12, 0 , n/2)
		divideMatrix(matrixB, B21, n/2, 0)   
		divideMatrix(matrixB, B22, n/2, n/2)

		M1 = strassenMethod(addMatrices(A11, A22), addMatrices(B11, B22))
		M2 = strassenMethod(addMatrices(A21, A22), B11)         
		M3 = strassenMethod(A11, subtractMatrices(B12, B22))
		M4 = strassenMethod(A22, subtractMatrices(B21, B11))  
		M5 = strassenMethod(addMatrices(A11, A12), B22)                      
		M6 = strassenMethod(subtractMatrices(A21, A11), addMatrices(B11, B12)) 
		M7 = strassenMethod(subtractMatrices(A12, A22), addMatrices(B21, B22))

		C11 = addMatrices(subtractMatrices(addMatrices(M1, M4), M5), M7)            
		C12 = addMatrices(M3, M5)                                                         
		C21 = addMatrices(M2, M4)                                                         
		C22 = addMatrices(subtractMatrices(addMatrices(M1, M3), M2), M6)

		copyToResult(C11, result, 0 , 0);    
		copyToResult(C12, result, 0 , n/2);  
		copyToResult(C21, result, n/2, 0);   
		copyToResult(C22, result, n/2, n/2);  

	return result



def copyToResult(subArray, mainArray, iP, jP):
	n = len(subArray)
	j1 = jP
	for i in xrange(0,n):
		for j in xrange(0,n):
			mainArray[iP][jP] = subArray[i][j]
			jP += 1
		iP += 1
		jP = j1


def divideMatrix(parent, child, iP, jP):
	# print child
	# print parent

	n = len(child)
	# print "len of child ", n
	# print "iP and iJ are ", iP, jP
	i1= iP
	j1 = jP
	for i in xrange(0,n):
		for j in xrange(0,n):
			# print "For child: ", i,j
			# print "For parent: length: ",len(parent), "but i & j are :", iP,jP
			child[i][j] = parent[iP][jP]
			jP += 1
		jP = j1
		iP += 1


# add two matrices
def addMatrices(a,b):
	n = len(a)
	result = [[0 for x in xrange(n)] for x in xrange(n)]
	for i in xrange(0,n):
		for j in xrange(0,n):
			result[i][j] = a[i][j] + b[i][j]

	return result


# subtract two matrices
def subtractMatrices(a,b):
	n = len(a)
	result = [[0 for x in xrange(n)] for x in xrange(n)]
	for i in xrange(0,n):
		for j in xrange(0,n):
			result[i][j] = a[i][j] - b[i][j]

	return result

def printMatrix(arr):
	for i in range(0, len(arr)):
		for j in range(0,len(arr)):
			print arr[i][j], " ",
		print 
	print "\n"

def powerOfTwo(n):
	twoPowers = [1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,\
    65536,131072,262144,524288,1048576,2097152,4194304,8388608,\
    16777216,33554432,67108864,134217728,268435456,536870912,\
    1073741824,2147483648]
	if n in twoPowers:
		return True
	else:
		return False

def nearestPowerOfTwo(n):
 	twoPowers = [1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,\
    65536,131072,262144,524288,1048576,2097152,4194304,8388608,\
    16777216,33554432,67108864,134217728,268435456,536870912,\
    1073741824,2147483648]
	for num in twoPowers:
		if num > n:
			return num



#######################################################
# take the input from the user
#######################################################


# order = int(input("Enter the order of matrix."))
# a = [[0 for x in xrange(order)] for x in xrange(order)] 
# b = [[0 for x in xrange(order)] for x in xrange(order)] 


# print "Enter the values for first matrix."
# for i in range(0,order):
# 	for j in range(0,order):
# 		print i,j
# 		a[i][j] = int(input("Enter the value of element: "))

# print "Enter the values for second matrix."
# for i in range(0, order):
# 	for j in range(0,order):
# 		b[i][j] = int(input("Enter the value of element: "))

##############################################################



### TEST CASE 1 ######

a = [[1,0,2], [4,1,1],[0,1,3]]
b = [[0,1,0],[2,1,0],[2,0,1]]

a = [[(x+1) for x in xrange(5)] for x in xrange(5) ]
b = [[(2*x + 3) for x in xrange(5)] for x in xrange(5)]
print "By strassen matrix multiplication method the product of two matrices is: "

print "******* Matrix A *******"
printMatrix(a)

print "******* Matrix B *******"
printMatrix(b) 

print "*** Resulted product ***"
c = strassenMethod(a, b)
printMatrix(c)


##### TEST CASE 2 ###########

a = [[1,0,2,1], [4,1,1,0],[0,1,3,0],[5,0,2,1]]
b = [[0,1,0,1],[2,1,0,4],[2,0,1,1],[1,3,5,0]]
print "By strassen matrix multiplication method the product of two matrices is: "

print "******* Matrix A *******"
printMatrix(a)

print "******* Matrix B *******"
printMatrix(b) 

print "*** Resulted product ***"
c = strassenMethod(a, b)
printMatrix(c)
