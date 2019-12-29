import csv

MIP = 0
NP = 1
labelList = ['1-Octanol', '1-Propanol', '2-Butanol', '2-Propanol', '1-isobutanol']

readFilePos = r'C:\Users\Administrator\Desktop\COMP7103\QCM Sensor Alcohol Dataset\QCM12.csv'
writeFilePos = r'C:\Users\Administrator\Desktop\COMP7103\QCM Sensor Alcohol Dataset\QCM12Trans.csv'
readFile = open(readFilePos, 'r')
writeFile = open(writeFilePos, 'w', newline='')
reader = csv.reader(readFile)
writer = csv.writer(writeFile)

skipOne = 0
for line in reader:
    skipOne += 1
    if skipOne == 1:
        continue
    elementsList = line[0].split(';')
    concen1 = (float(elementsList[0])+float(elementsList[1]))/2
    concen2 = (float(elementsList[2])+float(elementsList[3]))/2
    concen3 = (float(elementsList[4])+float(elementsList[5]))/2
    concen4 = (float(elementsList[6])+float(elementsList[7]))/2
    concen5 = (float(elementsList[8])+float(elementsList[9]))/2
    for i in range(5):
        if int(elementsList[10+i]) == 1:
            label = labelList[i]
    writer.writerow([concen1, concen2, concen3, concen4, concen5, MIP, NP, label])

writeFile.close()