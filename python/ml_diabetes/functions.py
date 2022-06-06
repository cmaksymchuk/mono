import pandas as pd
import matplotlib.pyplot as plt
import numpy as np
import sklearn


def set_options(pandas):
    pandas.set_option('display.max_columns', 10)
    pandas.set_option('display.width', 1000)
    
def print_head_tail(df, num):
    print (df.head(num))
    print (df.tail(num))

def print_null_values(df):
    print ('\nEmpty cells: {0}'.format(df.isnull().values.any()))

# blue is not correlated, yellow = highly correlated
def plot_corr(df,size=11):
    corr = df.corr()
    fig, ax = plt.subplots(figsize=(size,size))
    ax.matshow(corr)
    plt.xticks(range(len(corr.columns)), corr.columns)
    plt.yticks(range(len(corr.columns)), corr.columns)
    plt.show()
    
def print_corr(df):
    #show the correlation in text
    print(df.corr())

def del_skin(df):
    # skin and thickness are perfectly correlated so lets delete 'skin'
    del(df['skin'])

def tf_to_one_zero(df):
    #use pandas dataframes to move through the data change True to 1 and false to 0
    diabetes_map = {True : 1, False : 0}
    df['diabetes'] = df['diabetes'].map(diabetes_map)
    
def print_true_false_diabetes(df):    
    # Check number of true and false diabetes
    num_true = len(df.loc[df['diabetes'] == True])
    num_false = len(df.loc[df['diabetes'] == False])
    print("Number of True cases:  {0} ({1:2.2f}%)".format(num_true, (num_true/ (num_true + num_false)) * 100))
    print("Number of False cases: {0} ({1:2.2f}%)".format(num_false, (num_false/ (num_true + num_false)) * 100))
 
def train_test_split(df):
    from sklearn.model_selection import train_test_split
 
    feature_col_names = ['num_preg', 'glucose_conc', 'diastolic_bp', 'thickness', 'insulin', 'bmi', 'diab_pred', 'age']
    predicted_class_names = ['diabetes']
     
    X = df[feature_col_names].values     # predictor feature columns (8 X m)
    y = df[predicted_class_names].values # predicted class (1=true, 0=false) column (1 X m)
     
    split_test_size = 0.30
    X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=split_test_size, random_state=42)
    return X_train, X_test, y_train, y_test 
def print_train_test_split(X_train, X_test, y_train, y_test, df):
    # test_size = 0.3 is 30%, 42 is the answer to everything"
    # ensure training set is 70 and test is 30
    print("{0:0.2f}% in training set".format((len(X_train)/len(df.index)) * 100))
    print("{0:0.2f}% in test set".format((len(X_test)/len(df.index)) * 100))
    # Verify the true and false in the training and test sets have the same percentage of true and false
    print("Original True  : {0} ({1:0.2f}%)".format(len(df.loc[df['diabetes'] == 1]), (len(df.loc[df['diabetes'] == 1])/len(df.index)) * 100.0))
    print("Original False : {0} ({1:0.2f}%)".format(len(df.loc[df['diabetes'] == 0]), (len(df.loc[df['diabetes'] == 0])/len(df.index)) * 100.0))
    print("")
    print("Training True  : {0} ({1:0.2f}%)".format(len(y_train[y_train[:] == 1]), (len(y_train[y_train[:] == 1])/len(y_train) * 100.0)))
    print("Training False : {0} ({1:0.2f}%)".format(len(y_train[y_train[:] == 0]), (len(y_train[y_train[:] == 0])/len(y_train) * 100.0)))
    print("")
    print("Test True      : {0} ({1:0.2f}%)".format(len(y_test[y_test[:] == 1]), (len(y_test[y_test[:] == 1])/len(y_test) * 100.0)))
    print("Test False     : {0} ({1:0.2f}%)".format(len(y_test[y_test[:] == 0]), (len(y_test[y_test[:] == 0])/len(y_test) * 100.0)))

def print_hidden_missing_values(df):
    # Look for hidden missing values
    print("# rows in dataframe {0}".format(len(df)))
    print("# rows missing glucose_conc: {0}".format(len(df.loc[df['glucose_conc'] == 0])))
    print("# rows missing diastolic_bp: {0}".format(len(df.loc[df['diastolic_bp'] == 0])))
    print("# rows missing thickness: {0}".format(len(df.loc[df['thickness'] == 0])))
    print("# rows missing insulin: {0}".format(len(df.loc[df['insulin'] == 0])))
    print("# rows missing bmi: {0}".format(len(df.loc[df['bmi'] == 0])))
    print("# rows missing diab_pred: {0}".format(len(df.loc[df['diab_pred'] == 0])))
    print("# rows missing age: {0}".format(len(df.loc[df['age'] == 0])))
    
def impute_thickness_with_mean(X_train, X_test):        
    # What should we do with 0 skin thickness -> Imputing
    # Replace with mean or median?
    # Replace with expert knowlege derived value
    # Lets use the mean value
    # Scikit includes an imputer class    
    from sklearn.impute import SimpleImputer
    fill_0 = SimpleImputer(missing_values=0, strategy="mean", fill_value = "constant")    
    X_train = fill_0.fit_transform(X_train)
    X_test = fill_0.fit_transform(X_test)
    
def print_header():
    print("==========================================")

def apply_naive_bayes(X_train, y_train):
    # Evaluate the data against the test data
    # Interpret the results
    from sklearn.naive_bayes import GaussianNB

    #create Gaussian Naive bayes model object and train it with the data
    nb_model = GaussianNB() #Gausian Naive Bayes Algorithm
    # call the fit method to train the model
    nb_model.fit(X_train, y_train.ravel())
    return nb_model

def print_accuracy(X_train, X_test, y_train, y_test, nb_model, label):
    from sklearn import metrics
    nb_predict_train = nb_model.predict(X_train)
    print("\n====================== {0} ======================".format(label))
    print("\nAccuracy of training for {0}: {1:.4f}".format(label, metrics.accuracy_score(y_train, nb_predict_train)))
    
    nb_predict_test = nb_model.predict(X_test)
    print("Accuracy of test for {0}: {1:.4f}".format(label, metrics.accuracy_score(y_test, nb_predict_test)))
    
    
    print("\nConfusion Matrix for {0}".format(label))
    print("Format: ")
    print("[[TN FP]  (true negative, false positive)")
    print(" [FN TP]] (false negative, true positive)")
    print("Perfect looks like:")
    print(" [[151, 0]")
    print("  [0, 80]]")
    print("Ours looks like:")
    print("{0}".format(metrics.confusion_matrix(y_test, nb_predict_test)) + "\n")
    '''
    format TN FP (true negative, false positive)
    format FN TP (false negative, true positive)
    Our output was this:
    [[118  33]
     [ 28  52]]
    A perfect output would be this:
    [[151, 0]
    [0, 80]]
    
    Lets get sklearn to calculate some stats (with the classification repot).  It calcs based on the results of the confusion matrix)
    '''
    
    print("Classification Report for {0}".format(label))
    
    print(metrics.classification_report(y_test, nb_predict_test))
    '''
    Classification Report
                  precision    recall  f1-score   support
    
               0       0.81      0.78      0.79       151
               1       0.61      0.65      0.63        80
    
        accuracy                           0.74       231
       macro avg       0.71      0.72      0.71       231
    weighted avg       0.74      0.74      0.74       231
    
    Recall above is 0.65 which is TP / (TP/FN) 
    Recall is true positive rate which is how often we predict true diabetes when the result is actually true diabetes
    We need to get this number to > .7
    
    Precision (0.61) is how often the patient actually had diabetes when the model said they would
    Precision = TP / (TP + FP)
    We want to improve this number too
     
    '''


def apply_random_forest(X_train, y_train):    
    # Lets switch to random forest algorithm
    from sklearn.ensemble import RandomForestClassifier
    rf_model = RandomForestClassifier(random_state=42)      # Create random forest object
    rf_model.fit(X_train, y_train.ravel())
    return rf_model 

def apply_logistic_regression(X_train, y_train, c_value, class_weight):
    from sklearn.linear_model import LogisticRegression
    
    lr_model =LogisticRegression(C=c_value, random_state=42, solver='liblinear', class_weight=class_weight)
    lr_model.fit(X_train, y_train.ravel())
    return lr_model 

def get_best_cvalue(X_train, X_test, y_train, y_test, class_weight):
    from sklearn.linear_model import LogisticRegression
    from sklearn import metrics
    #Lets loop through the regularization parameter and find the best one
    # try c values from 0-4.9 with increments of 0.1
    C_start = 0.1
    C_end = 5
    C_inc = 0.1
    
    C_values, recall_scores = [], []
    
    C_val = C_start
    best_recall_score = 0
    while (C_val < C_end):
        C_values.append(C_val)
        lr_model_loop = LogisticRegression(C=C_val, random_state=42, solver='liblinear', class_weight=class_weight)
        lr_model_loop.fit(X_train, y_train.ravel())
        lr_predict_loop_test = lr_model_loop.predict(X_test)
        recall_score = metrics.recall_score(y_test, lr_predict_loop_test)
        recall_scores.append(recall_score)
        if (recall_score > best_recall_score):
            best_recall_score = recall_score
            best_lr_predict_test = lr_predict_loop_test
            
        C_val = C_val + C_inc
    
    best_score_C_val = C_values[recall_scores.index(best_recall_score)]
    print("When class_weight set to [{0}], max value of {1:.3f} occurred at C={2:.3f}".format(class_weight, best_recall_score, best_score_C_val))
    # output = 1st max value of 0.613 occured at C=1.400
    # maybe the problem is that we have more non-diabetes results than diabetes results in our data which 
    # means that we have 'unbalanced classes'
    # Lets enable this 
    
def get_best_cvalue_fold(X_train, X_test, y_train, y_test, class_weight):
    from sklearn.linear_model import LogisticRegressionCV
    from sklearn import metrics
    #Lets loop through the regularization parameter and find the best one
    # try c values from 0-4.9 with increments of 0.1
    C_start = 0.1
    C_end = 5
    C_inc = 0.1
    
    C_values, recall_scores = [], []
    
    C_val = C_start
    best_recall_score = 0
    
    while (C_val < C_end):
        C_values.append(C_val)
        lr_model_loop = LogisticRegressionCV(n_jobs=-1, solver='liblinear', random_state=42, Cs=3, cv=10, refit=False, class_weight=class_weight)  # set number of jobs to -1 which uses all cores to parallelize
        lr_model_loop.fit(X_train, y_train.ravel())
        lr_predict_loop_test = lr_model_loop.predict(X_test)
        recall_score = metrics.recall_score(y_test, lr_predict_loop_test)
        recall_scores.append(recall_score)
        if (recall_score > best_recall_score):
            best_recall_score = recall_score + best_recall_score
            best_lr_predict_test = lr_predict_loop_test
            
        C_val = C_val + C_inc
        
    best_recall_score = best_recall_score / ((C_end / C_inc) - 1 )
    
#best_score_C_val = C_values[recall_scores.index(best_recall_score)]
#print("Folded: When class_weight set to [{0}], max value of {1:.3f} occurred at C={2:.3f}".format(class_weight, best_recall_score, best_score_C_val))
    # output = 1st max value of 0.613 occured at C=1.400
    # maybe the problem is that we have more non-diabetes results than diabetes results in our data which 
    # means that we have 'unbalanced classes'
    # Lets enable this 

def apply_logistic_regression_fold(X_train, y_train, X_test, y_test, c_value, class_weight):

    from sklearn.linear_model import LogisticRegressionCV
    from sklearn import metrics

    lr_cv_model = LogisticRegressionCV(n_jobs=-1, random_state=42, solver='liblinear', Cs=3, cv=10, refit=False, class_weight=class_weight)  # set number of jobs to -1 which uses all cores to parallelize
    lr_cv_model.fit(X_train, y_train.ravel())
    
    lr_cv_predict_test = lr_cv_model.predict(X_test)
    # training metrics,
    print("Accuracy: {0:.4f}".format(metrics.accuracy_score(y_test, lr_cv_predict_test)))
    print(metrics.confusion_matrix(y_test, lr_cv_predict_test) )
    print("")
    print("Classification Report")
    print(metrics.classification_report(y_test, lr_cv_predict_test))