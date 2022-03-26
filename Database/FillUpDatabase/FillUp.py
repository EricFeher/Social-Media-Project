import random

import requests

gender=""
f = open("users.sql", "w")
f.write("")
f.close()
f = open("users.sql", "a")
response=requests.get("https://random-data-api.com/api/users/random_user?size=100")
data=response.json()
response=requests.get("https://random-data-api.com/api/users/random_user?size=100")
data+=response.json()
response=requests.get("https://random-data-api.com/api/users/random_user?size=100")
data+=response.json()
locationID=0
schoolID=0
workplaceID=0
userID=0
for i in range(1,300):
    userID+=1
    dataUsers=data[i]
    f.write("INSERT INTO ENDUSER (username, password, email) values('"+dataUsers["username"].replace("'","_")+"', '"+dataUsers["password"].replace("'","_")+"', '"+dataUsers["email"].replace("'","_")+"');\n")
    f.write("INSERT INTO LOCATION (postcode, city, street, housenumber) values('"+dataUsers["address"]["zip_code"].replace("'","_")+"', '"+dataUsers["address"]["city"].replace("'","_")+"', '"+dataUsers["address"]["street_name"].replace("'","_")+"', '"+str(random.randint(0,100))+"');\n")
    locationID+=1
    f.write("INSERT INTO PHOTOS (user_id, photo) values('"+str(i)+"', 'deflt.jpg');\n")
    if random.randint(0,2) == 1:
        gender="f"
    else:
        gender="m"
    f.write("INSERT INTO USERDATA (user_id, location_id, photo_id, first_name, last_name, gender, birthday) values('"+str(i)+"', '"+str(i)+"', '"+str(i)+"', '"+dataUsers['first_name'].replace("'","_")+"', '"+dataUsers['last_name'].replace("'","_")+"', '"+gender+"', TO_DATE('"+dataUsers['date_of_birth']+"', 'yyyy-mm-dd'));\n")

response=requests.get("https://random-data-api.com/api/company/random_company?size=10").json()
users=requests.get("https://random-data-api.com/api/users/random_user?size=10").json()
for i in range(1,10):
    workplaceID+=1
    data=response[i]
    dataUsers=users[i]
    locationID += 1
    f.write("INSERT INTO LOCATION (postcode, city, street, housenumber) values('" + dataUsers["address"][
        "zip_code"].replace("'", "_") + "', '" + dataUsers["address"]["city"].replace("'", "_") + "', '" +
            dataUsers["address"]["street_name"].replace("'", "_") + "', '" + str(random.randint(1, 100)) + "');\n")
    f.write("INSERT INTO WORKPLACE (location_id, name, workplace_type) values('"+str(locationID)+"', '"+data["business_name"].replace("'","_").replace("&","_")+"', '"+data["industry"].replace("'","_").replace("&","_")+"');\n")

response=requests.get("https://random-data-api.com/api/company/random_company?size=10").json()
users=requests.get("https://random-data-api.com/api/users/random_user?size=10").json()
for i in range(1,10):
    schoolID+=1
    data=response[i]
    dataUsers=users[i]
    locationID += 1
    f.write("INSERT INTO LOCATION (postcode, city, street, housenumber) values('" + dataUsers["address"][
        "zip_code"].replace("'", "_") + "', '" + dataUsers["address"]["city"].replace("'", "_") + "', '" +
            dataUsers["address"]["street_name"].replace("'", "_") + "', '" + str(random.randint(1, 100)) + "');\n")
    f.write("INSERT INTO SCHOOL (location_id, name, school_type) values('"+str(locationID)+"', '"+data["business_name"].replace("'","_").replace("&","_")+"', '"+data["industry"].replace("'","_").replace("&","_")+"');\n")

for i in range(1,userID+1):
    if i%2==0:
        f.write("INSERT INTO WORKPLACE_USER_CONNECTOR (user_id, workplace_id) values ('"+str(i)+"', '"+str(random.randint(1,workplaceID))+"');\n")
    else:
        f.write(
            "INSERT INTO SCHOOL_USER_CONNECTOR (user_id, school_id) values ('" + str(i) + "', '" + str(random.randint(
                1, schoolID)) + "');\n")

f.write("INSERT INTO POST (user_id, content) values ('"+str(random.randint(1,userID))+"', 'Szia ez az elso poszt');\n")
f.write("INSERT INTO POST (user_id, content) values ('"+str(random.randint(1,userID))+"', 'Szia ez a masodik poszt');\n")
f.write("INSERT INTO POST (user_id, content) values ('"+str(random.randint(1,userID))+"', 'Szia ez a harmadik poszt');\n")
f.write("INSERT INTO POST (user_id, content) values ('"+str(random.randint(1,userID))+"', 'Szia ez aa negyedik poszt');\n")
f.write("INSERT INTO POST (user_id, content) values ('"+str(random.randint(1,userID))+"', 'Szia ez a otodik poszt');\n")
postID=5

for i in range(1,userID+1):
    f.write("INSERT INTO POST_LIKES (user_id, post_id) values ('" + str(i) + "', '" + str(
        random.randint(1, postID)) + "');\n")

f.write("INSERT INTO COMMENTS (user_id, post_id, content) values ('"+str(random.randint(1,userID))+"', '" + str(random.randint(1, postID)) +"', 'Szia ez az elso komment');\n")
f.write("INSERT INTO COMMENTS (user_id, post_id, content) values ('"+str(random.randint(1,userID))+"', '" + str(random.randint(1, postID)) +"', 'Szia ez a masodik komment');\n")
f.write("INSERT INTO COMMENTS (user_id, post_id, content) values ('"+str(random.randint(1,userID))+"', '" + str(random.randint(1, postID)) +"', 'Szia ez a harmadik komment');\n")
f.write("INSERT INTO COMMENTS (user_id, post_id, content) values ('"+str(random.randint(1,userID))+"', '" + str(random.randint(1, postID)) +"', 'Szia ez a nengyedik komment');\n")
f.write("INSERT INTO COMMENTS (user_id, post_id, content) values ('"+str(random.randint(1,userID))+"', '" + str(random.randint(1, postID)) +"', 'Szia ez a otodik komment');\n")

commentID=5

for i in range(1,userID+1):
    f.write("INSERT INTO COMMENTS_LIKES (user_id, comment_id) values ('" + str(i) + "', '" + str(
        random.randint(1, commentID)) + "');\n")


groupID=5
f.write("INSERT INTO GROUPS (name, description) values ('Poni bolygok szeretoi', 'Sziasztok mi itt nagyon szeretjuk a poni bolygokat.');\n")
f.write("INSERT INTO GROUPS (name, description) values ('Hernyo bolygok szeretoi', 'Sziasztok mi itt nagyon szeretjuk a hernyo bolygokat.');\n")
f.write("INSERT INTO GROUPS (name, description) values ('Katica bolygok szeretoi', 'Sziasztok mi itt nagyon szeretjuk a katica bolygokat.');\n")
f.write("INSERT INTO GROUPS (name, description) values ('Macska bolygok szeretoi', 'Sziasztok mi itt nagyon szeretjuk a macska bolygokat.');\n")
f.write("INSERT INTO GROUPS (name, description) values ('Mercso Gark bolygok szeretoi', 'Sziasztok mi itt nagyon szeretjuk a Mercso Gark bolygokat.');\n")


for i in range(1,userID+1):
    f.write("INSERT INTO GROUPS_MEMBERS (user_id, group_id) values ('"+str(i)+"', '" + str(random.randint(1, groupID))+"');\n")

for i in range(1,groupID+1):
    f.write("INSERT INTO GROUPS_ADMINS (user_id, group_id) values ('" + str(random.randint(1,userID)) + "', '" + str(i) + "');\n")


messageID=5
f.write("INSERT INTO MESSAGE (user_id1, user_id2, content) values ('"+str(random.randint(1,userID))+"', '"+str(random.randint(1,userID))+"', 'Sziaaaaa elso uzi.');\n")
f.write("INSERT INTO MESSAGE (user_id1, user_id2, content) values ('"+str(random.randint(1,userID))+"', '"+str(random.randint(1,userID))+"', 'Sziaaaaa masodik uzi.');\n")
f.write("INSERT INTO MESSAGE (user_id1, user_id2, content) values ('"+str(random.randint(1,userID))+"', '"+str(random.randint(1,userID))+"', 'Sziaaaaa harmaidk uzi.');\n")
f.write("INSERT INTO MESSAGE (user_id1, user_id2, content) values ('"+str(random.randint(1,userID))+"', '"+str(random.randint(1,userID))+"', 'Sziaaaaa negyedik uzi.');\n")
f.write("INSERT INTO MESSAGE (user_id1, user_id2, content) values ('"+str(random.randint(1,userID))+"', '"+str(random.randint(1,userID))+"', 'Sziaaaaa otodik uzi.');\n")


for i in range(1, userID+1):
    rand2=i
    while i==rand2:
        rand2=random.randint(1,userID)
    f.write("INSERT INTO FOLLOWS (user_id1, user_id2) values ('" + str(i) + "', '" + str(rand2) + "');\n")

f.close()