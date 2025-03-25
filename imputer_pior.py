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

train_data.dropna( subset='SalePrice', inplace=True )
y = train_data.SalePrice
train_data.drop( 'SalePrice', axis=1, inplace=True )
x = train_data.select_dtypes( exclude='object' )
x_test = test_data.select_dtypes( exclude='object' )

imputer = SimpleImputer()
imputed_x = pd.DataFrame( imputer.fit_transform(x) )
imputed_x.columns = x.columns

model = RandomForestRegressor( random_state=1 )
model.fit( imputed_x, y )

imputed_x_test = pd.DataFrame( imputer.fit_transform(x_test) )
imputed_x_test.columns = x_test.columns

preds = model.predict( imputed_x_test )

output = pd.DataFrame( {
    'Id': test_data.index,
    'SalePrice': preds
} )

output.to_csv( 'submission.csv', index=False )
