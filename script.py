import random
from datetime import datetime, timedelta

# or a function
def gen_datetime(min_year=2015, max_year=datetime.now().year):
    # generate a datetime in format yyyy-mm-dd hh:mm:ss.000000
    start = datetime(min_year, 1, 1, 00, 00, 00)
    years = max_year - min_year + 1
    end = start + timedelta(days=365 * years)
    return start + (end - start) * random.random()

# print(str(gen_datetime()).split('.')[0])   
errors = ["DEBUG", "INFO", "WARNING", "ERROR", "CRITICAL", "FATAL"]
user_name = ["Manas", "Jashn", "Anishka", "Viksit", "Anubhav"]
error_name = ["Authentication Error", "Connection Failed", "OutputCommitter set in config null", "Execution Error", "Proxy Error"]
i = 0
with open('check.log','w') as f:

    while(True):
        line = str(gen_datetime()).split('.')[0] + " " + random.choice(errors) + ":["+ random.choice(user_name)+"]:" + random.choice(error_name) 
        f.write(line + "\n")
        i += 1
        if(i%1000000 == 0):
            print(i)
        if(i > 100000000):
            break

