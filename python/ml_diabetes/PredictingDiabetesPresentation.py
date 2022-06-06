'''
Created on Aug 13, 2019

@author: cmaksym
'''

import pandas as pd
import matplotlib.pyplot as plt
import numpy as np
import sklearn


from functions import set_options
from functions import print_head_tail
from functions import print_null_values
from functions import plot_corr
from functions import print_corr
from functions import del_skin
from functions import tf_to_one_zero
from functions import print_true_false_diabetes
from functions import train_test_split
from functions import print_train_test_split
from functions import print_hidden_missing_values
from functions import impute_thickness_with_mean
from functions import print_header
from functions import apply_naive_bayes
from functions import apply_random_forest
from functions import apply_logistic_regression
from functions import print_accuracy
from functions import get_best_cvalue
from functions import get_best_cvalue_fold
from functions import apply_logistic_regression_fold

set_options(pd)

#Read / Inspect
df = pd.read_csv("C:\dev\git\mlwithpython\data\pima-data.csv")
print_head_tail(df, 5)

# # Clean 
print_null_values(df)
# plot_corr(df)          
print_corr(df) 
del_skin(df)
print_head_tail(df, 5)
# plot_corr(df)
# 
# # Mold
print_head_tail(df, 5)
tf_to_one_zero(df)
print_head_tail(df, 5)
print_true_false_diabetes(df)                                
# # =======================================================
# # train test split start
# # =======================================================
# X = feature columns
# y = class column

X_train, X_test, y_train, y_test = train_test_split(df)
print_train_test_split(X_train, X_test, y_train, y_test, df)
#  
# # =======================================================
# # impute with mean start
# # =======================================================
print_hidden_missing_values(df)
from sklearn.impute import SimpleImputer
fill_0 = SimpleImputer(missing_values=0, strategy="mean", fill_value = "constant")    
X_train = fill_0.fit_transform(X_train)
X_test = fill_0.fit_transform(X_test)

#  
# # =======================================================
# # Start Naive Bayes 
# # =======================================================
nb_model = apply_naive_bayes(X_train, y_train)
print_accuracy(X_train, X_test, y_train, y_test, nb_model, 'NAIVE BAYES')
#  
# # =======================================================
# # Start Random Forest 
# # =======================================================
rf_model = apply_random_forest(X_train, y_train)
print_accuracy(X_train, X_test, y_train, y_test, rf_model, 'RANDOM FOREST')
#  
# 
# # =======================================================
# # Start Logistics Regression 
# # =======================================================
class_weight = ''
c_value = 0.7
lr_model = apply_logistic_regression(X_train, y_train, c_value, class_weight)
print_accuracy(X_train, X_test, y_train, y_test, lr_model, 'Logistic Regression with class_weight=[{0}] and c_value=[{1}]'.format(class_weight, c_value))
#  
# # =======================================================
# # Get best C Value
# # =======================================================
class_weight = ''
get_best_cvalue(X_train, X_test, y_train, y_test, '')
# 
# # =======================================================
# # Logistics Regression using optimal C Value (1.4)
# # =======================================================
class_weight=''
c_value=1.4
lr_model = apply_logistic_regression(X_train, y_train, c_value, class_weight)
print_accuracy(X_train, X_test, y_train, y_test, lr_model, 'Logistic Regression with class_weight=[{0}] and c_value=[{1}]'.format(class_weight, c_value))
# 
# # =======================================================
# # Getting Best C Value when the data is balanced
# # =======================================================
# 
get_best_cvalue(X_train, X_test, y_train, y_test, 'balanced')

# # =======================================================
# # Logistics Regression with balanced classes and optimal c value
# # =======================================================
class_weight='balanced'
c_value=0.3
lr_model = apply_logistic_regression(X_train, y_train, c_value, class_weight)
print_accuracy(X_train, X_test, y_train, y_test, lr_model, 'Logistic Regression with class_weight=[{0}] and c_value=[{1}]'.format(class_weight, c_value))

# # =======================================================
# # Logistics Regression with balanced classes and optimal c value folded
# # =======================================================
# c_value="0.100"
# class_weight='balanced'
# get_best_cvalue_fold(X_train, X_test, y_train, y_test, 'balanced')
# apply_logistic_regression_fold(X_train, y_train, X_test, y_test, c_value, class_weight)
