# # Distance matrix between major cities in the US
# # This can be replaced with a dynamic API call to get real-time distances
# distances = {
#     'New York': {'Chicago': 790, 'San Francisco': 2900, 'Miami': 1300, 'Los Angeles': 2790},
#     'Chicago': {'New York': 790, 'San Francisco': 2130, 'Miami': 1380, 'Los Angeles': 1750},
#     'San Francisco': {'New York': 2900, 'Chicago': 2130, 'Miami': 3060, 'Los Angeles': 380},
#     'Miami': {'New York': 1300, 'Chicago': 1380, 'San Francisco': 3060, 'Los Angeles': 2730},
#     'Los Angeles': {'New York': 2790, 'Chicago': 1750, 'San Francisco': 380, 'Miami': 2730}
# }

# # Floyd-Warshall algorithm implementation
# def floyd_warshall(distances):
#     n = len(distances)
#     # Initialize the distance matrix with the given distances
#     D = [[distances[i][j] if j in distances[i] else float('inf') for j in distances] for i in distances]
#     # Compute the shortest distance between each pair of cities using dynamic programming
#     for k in range(n):
#         for i in range(n):
#             for j in range(n):
#                 D[i][j] = min(D[i][j], D[i][k] + D[k][j])
#     return D

# # Get user input for the source and destination cities
# source = input("Enter the source city: ")
# destination = input("Enter the destination city: ")

# # Call the Floyd-Warshall function to get the shortest path between the source and destination cities
# distances_matrix = floyd_warshall(distances)
# shortest_distance = distances_matrix[list(distances.keys()).index(source)][list(distances.keys()).index(destination)]

# # Print the shortest distance between the source and destination cities
# print(f"The shortest distance between {source} and {destination} is {shortest_distance} miles.")



from geopy.distance import geodesic

# Latitude and longitude of major cities in the US
# Source: https://developers.google.com/public-data/docs/canonical/countries_csv
coordinates = {
    'New York': (40.7128, -74.0060),
    'Chicago': (41.8781, -87.6298),
    'San Francisco': (37.7749, -122.4194),
    'Miami': (25.7617, -80.1918),
    'Los Angeles': (34.0522, -118.2437),
    'Houston': (29.7604, -95.3698),
    'Dallas': (32.7767, -96.7970),
    'Seattle': (47.6062, -122.3321),
    'Atlanta': (33.7490, -84.3880),
    'Boston': (42.3601, -71.0589),
    'Phoenix': (33.4484, -112.0740),
    'Denver': (39.7392, -104.9903),
    'San Diego': (32.7157, -117.1611),
    'Washington': (38.9072, -77.0369),
    'Detroit': (42.3314, -83.0458),
    'Minneapolis': (44.9778, -93.2650),
    'Tampa': (27.9506, -82.4572),
    'St. Louis': (38.6270, -90.1994),
    'Baltimore': (39.2904, -76.6122),
    'San Antonio': (29.4241, -98.4936),
    'Portland': (45.5234, -122.6762),
    'Orlando': (28.5383, -81.3792),
    'Sacramento': (38.5816, -121.4944),
    'Kansas City': (39.0997, -94.5786),
    'Columbus': (39.9612, -82.9988)
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



