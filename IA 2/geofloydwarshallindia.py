from geopy.distance import geodesic

# Latitude and longitude of major cities in India
coordinates = {
    'Mumbai': (19.0760, 72.8777),
    'Delhi': (28.7041, 77.1025),
    'Bangalore': (12.9716, 77.5946),
    'Hyderabad': (17.3850, 78.4867),
    'Ahmedabad': (23.0225, 72.5714),
    'Chennai': (13.0827, 80.2707),
    'Kolkata': (22.5726, 88.3639),
    'Surat': (21.1702, 72.8311),
    'Pune': (18.5204, 73.8567),
    'Jaipur': (26.9124, 75.7873),
    'Lucknow': (26.8467, 80.9462),
    'Kanpur': (26.4499, 80.3319),
    'Nagpur': (21.1458, 79.0882),
    'Indore': (22.7196, 75.8577),
    'Thane': (19.2183, 72.9781),
    'Bhopal': (23.2599, 77.4126),
    'Visakhapatnam': (17.6868, 83.2185),
    'Pimpri-Chinchwad': (18.6279, 73.8009),
    'Patna': (25.5941, 85.1376),
    'Vadodara': (22.3072, 73.1812),
    'Ghaziabad': (28.6692, 77.4538),
}

# Compute the distance matrix between the cities based on their coordinates
distances = {}
for city1 in coordinates:
    for city2 in coordinates:
        if city1 != city2:
            distance = geodesic(coordinates[city1], coordinates[city2]).miles
            if city1 not in distances:
                distances[city1] = {}
            distances[city1][city2] = int(distance)

# Floyd-Warshall algorithm implementation
def floyd_warshall(distances):
    n = len(distances)
    # Initialize the distance matrix with the given distances
    D = [[distances[i][j] if j in distances[i] else float('inf') for j in distances] for i in distances]
    # Compute the shortest distance between each pair of cities using dynamic programming
    for k in range(n):
        for i in range(n):
            for j in range(n):
                D[i][j] = min(D[i][j], D[i][k] + D[k][j])
    return D

# Get user input for the source and destination cities
source = input("Enter the source city: ")
destination = input("Enter the destination city: ")

# Call the Floyd-Warshall function to get the shortest path between the source and destination cities
distances_matrix = floyd_warshall(distances)
shortest_distance = distances_matrix[list(distances.keys()).index(source)][list(distances.keys()).index(destination)]

# Print the shortest distance between the source and destination cities
print(f"The shortest distance between {source} and {destination} is {shortest_distance} miles.")