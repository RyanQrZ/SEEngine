#! /bin/python3

import pandas as pd
from sklearn.ensemble import RandomForestRegressor
from sklearn.model_selection import train_test_split
from sklearn.metrics import mean_absolute_error
from sklearn.impute import SimpleImputer

# Get accuracy of a dataset
def get_accuracy( x, y ):
    x_train, x_valid = train_test_split( x, random_state=1 )
    y_train, y_valid = train_test_split( y, random_state=1 )

    model = RandomForestRegressor( random_state=1 )
    
    model.fit( x_train, y_train )
    preds = model.predict( x_valid )

    return mean_absolute_error( y_valid, preds )

# Make predictions using Random Forest
def make_preds( x_train, y_train, x_test ):
    rf_model = RandomForestRegressor( random_state=1 )
    rf_model.fit( x, y )
    
    return rf_model.predict( x_test )
    

train_data = pd.read_csv( './train.csv', index_col='Id' )
test_data = pd.read_csv( './test.csv', index_col='Id' )

train_data.dropna(  subset='SalePrice', inplace=True )
y = train_data.SalePrice
train_data.drop( 'SalePrice', axis=1, inplace=True )
x = train_data.select_dtypes( exclude='object' )
x_test = test_data.select_dtypes( exclude='object' )

# ----------------------- DROP APPROACH -----------------------
col_with_na = []
for i in x.columns:
    if( x[i].isnull().any() ):
        col_with_na.append( i )

reduced_x = x.drop( col_with_na, axis=1 )
print( f"DROP: \t{get_accuracy(reduced_x, y)}" )
# ----------------------- DROP APPROACH -----------------------

# ---------------------- IMPUT APPROACH -----------------------
imputer = SimpleImputer()
x_train, x_valid = train_test_split( x, train_size=0.8, random_state=1 )
y_train, y_valid = train_test_split( y, train_size=0.8, random_state=1 )

imputed_x_train = pd.DataFrame( imputer.fit_transform(x_train) )
imputed_x_valid = pd.DataFrame( imputer.transform(x_valid) )

imputed_x_train.columns = x_train.columns
imputed_x_valid.columns = x_valid.columns

model = RandomForestRegressor( random_state=1 )
model.fit( imputed_x_train, y_train )

preds = model.predict( imputed_x_valid )
print( f"IMPUT: \t{mean_absolute_error(y_valid, preds)}" )
# ---------------------- IMPUT APPROACH -----------------------
