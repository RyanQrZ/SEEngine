#! /bin/python3

import pandas as pd
from sklearn.ensemble import RandomForestRegressor
from sklearn.model_selection import train_test_split
from sklearn.metrics import mean_absolute_error

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
    
features = [ 'LotArea', 'MSSubClass', 'OverallQual',
             'OverallCond', 'YearBuilt', 'YearRemodAdd',
             '1stFlrSF', '2ndFlrSF', 'LowQualFinSF',
             'FullBath', 'GrLivArea', 'HalfBath',
             'KitchenAbvGr', 'Fireplaces', 'ScreenPorch',
             'PoolArea', 'MiscVal',  'GarageCars',
             'MiscVal', 'BsmtFullBath', 'BsmtUnfSF',
             'BsmtFinSF1', 'LandContour', 'Neighborhood',
             'Street', 'BldgType' ]

features2 = [ 'LotArea', 'YearBuilt', '1stFlrSF',
              '2ndFlrSF', 'FullBath', 'BedroomAbvGr',
              'TotRmsAbvGrd' ]

x = pd.get_dummies( train_data[features] )
y = train_data.SalePrice
x_test = pd.get_dummies( test_data[features] )

print( get_accuracy(x, y) )

"""
output = pd.DataFrame( {
    'Id': test_data.index,
    'SalePrice': make_preds( x, y, x_test )
} )

output.to_csv( 'submission.csv', index=False )
print( "DONE!" )
"""
