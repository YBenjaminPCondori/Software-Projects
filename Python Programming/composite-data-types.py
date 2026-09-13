import csv
import copy


myVehicle = {
    "vin": "<empty>",
    "make": "<empty>",
    "model": "<empty>",
    "year": 0,
    "range": 0,
    "topSpeed": 0,
    "zeroSixty": 0.0,
    "mileage": 0
}


# An empty list to store the inventory
myInventoryList = []


# The loop to print the initial empty myVehicle dictionary had an AttributeError.
# "key.Value" is not valid. The variables are key and value.
# Also, the myInventoryList declaration was incorrectly inside this loop.
for key, value in myVehicle.items():
    print(f"{key} : {value}")


# Corrected indentation for the "with open" block.
# It should not be nested inside the previous for loop.
with open('Car_Fleet.csv') as csvFile:
    csvReader = csv.reader(csvFile, delimiter=',')
    lineCount = 0
    for row in csvReader:
        if lineCount == 0:
            print(f'Column names are: {", ".join(row)}')
            lineCount += 1
        else:
            print(f'vin: {row[0]} make: {row[1]}, model: {row[2]}, year: {row[3]}, range: {row[4]}, topSpeed: {row[5]}, zeroSixty: {row[6]}, mileage: {row[7]}')
            currentVehicle = copy.deepcopy(myVehicle)

            # Assigning values from the row to the dictionary
            currentVehicle["vin"] = row[0]
            currentVehicle["make"] = row[1]
            currentVehicle["model"] = row[2]
            currentVehicle["year"] = int(row[3])
            currentVehicle["range"] = int(row[4])
            currentVehicle["topSpeed"] = int(row[5])
            currentVehicle["zeroSixty"] = float(row[6])
            currentVehicle["mileage"] = int(row[7])

            # Append the completed dictionary to the list
            myInventoryList.append(currentVehicle)
            lineCount += 1

    # This print statement was incorrectly indented and should be outside the for loop
    print(f'Processed {lineCount} lines.')

# The final loop to print the inventory was also incorrectly indented.
# It should be a new, separate loop at the same level as the "with open" statement.
for myCarProperties in myInventoryList:
    for key, value in myCarProperties.items():
        print("{} : {}")
    print("-----")