#!/usr/bin/env python
# coding: utf-8

# In[4]:


import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
import seaborn as sns
sns.set()


# In[5]:


cities=['A','B','C','D','E','F','G']
true_path = ['A','B','C']


# In[6]:


def create_environment(cities = ['A','B','C','D','E','F','G'],  path = ['A', 'F', 'D','E']):
    def distance_matrix(cities, path):
        N =len(cities)
        env = pd.DataFrame(data=np.ones((N,N)) * 10, columns=cities, index = cities)      
        ## -1: disallowed passage
        for i in range(N):
            env.loc[cities[i], cities[i]] = -1

        for i in range(len(path)-1):
            env.loc[path[i], path[i+1]] = 1
            env.loc[path[i+1],path[i]]=1
          

        return env

    def pheremon_matrix(cities, eps = 0.0001):
        N =len(cities)
        return pd.DataFrame(data=np.ones((N,N)) * eps, columns=cities, index = cities)

    return distance_matrix(cities, path), pheremon_matrix(cities)


# In[7]:


env, phe = create_environment(cities=cities,path=true_path)


# In[ ]:


env


# In[ ]:


phe


# In[8]:


class ant():
    def __init__(self, env , phe , 
                 start = 'A', end = 'E',
                alpha = 1, beta = 1,eva=0.6):
        
        self.env, self.phe  = env, phe
        self.alpha, self.beta = alpha, beta
        self.cities = list(self.env.columns)
        self.current_city = start
        self.route = [self.current_city]
        self.end=end
        self.eva=eva
        self.possible_cities = self.cities.copy()
        self.possible_cities.remove(self.current_city)
    
              
    def update(self,currentcity,route):
        a=self.route.index(currentcity)
        
        distance=1/env.loc[currentcity ,[route[a-1]]]
        phe.loc[currentcity ,[route[a-1]]]=(1-self.eva)*phe.loc[currentcity ,[route[a-1]]] + distance
        phe.loc[[route[a-1]],currentcity ]=phe.loc[currentcity ,[route[a-1]]]
        
    def fuel(self,cc,route):
        a=self.route.index(cc)
        print(a)
        for i in range (0,len(cities)):
            for j in range (0,len(cities)):
                
                if(not((cities[i]==cc) and (cities[j]==route[a-1])) or((cities[j]==cc) and (cities[i]==route[a-1]))):
                    phe.loc[cities[i],cities[j]]=(1-self.eva)*phe.loc[cities[i],cities[j]]
                    phe.loc[cities[j],cities[i]]=phe.loc[cities[i],cities[j]]
             
        
    def move(self):
        
        if(not(self.current_city)==self.end):  
            distances = env.loc[self.current_city , env.loc[self.current_city ] > 0][self.possible_cities]
            pheremons = phe.loc[self.current_city , env.loc[self.current_city ] > 0][self.possible_cities]
           
            preferences = pheremons**self.alpha/distances**self.beta
            probabilities = preferences/preferences.sum()
            print(probabilities)
            self.current_city = np.random.choice(a = probabilities.index,  size=1, p = probabilities.values)[0]
            
            self.route.append(self.current_city) 
            self.possible_cities.remove(self.current_city)
            self.update(self.current_city,self.route)
            self.fuel(self.current_city,self.route)      
            


# In[9]:


cities = ['A','B','C','D','E','F','G']
true_path = ['A', 'F','D','E']
env, phe = create_environment(cities=cities,path=true_path)
a=ant(env=env,phe=phe)


# In[ ]:


phe


# In[10]:


cities = ['A','B','C','D','E','F','G']
true_path = ['A', 'F','D','E']
env, phe = create_environment(cities = cities, path = true_path)

eps = 0.0001
K = 3
time = 3
true_path_ratio = []

# in each time step
for t in range(time):
    # k ants exist in the colony
    colony = [ant(env = env, phe =phe) for k in range(K)]
    
    # each ant make N moves 
    for i in range(len(cities)):
        # distributed and paralel moves of K ants
        for k in range(K):
            colony[k].move()
        # after independent moves, ants deposit pheremon
        
    true_path_ratio.append(np.mean([a.route == true_path for a in colony]))  


# In[11]:


true_path_ratio


# In[ ]:


cities


# In[ ]:


a.move()
print(a.route)
a.current_city   


# In[ ]:


phe


# In[ ]:


a.move()
print(a.route)
a.current_city   


# In[ ]:


phe


# In[ ]:


a.move()
print(a.route)
a.current_city   


# In[ ]:


phe


# In[ ]:


a.move()
print(a.route)
a.current_city   


# In[ ]:


a.move()
print(a.route)
a.current_city   


# In[ ]:


a.move()
print(a.route)
a.current_city   


# In[ ]:


phe


# In[ ]:




