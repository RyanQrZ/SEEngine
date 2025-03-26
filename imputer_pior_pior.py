#! /bin/python3

import pandas as pd
from sklearn.impute import SimpleImputer
from sklearn.ensemble import RandomForestRegressor

train_data = pd.read_csv( './train.csv', index_col='Id' )
test_data = pd.read_csv( './test.csv', index_col='Id' )

train_data.dropna( subset='SalePrice', inplace=True )
y = train_data.SalePrice
train_data.drop( 'SalePrice', axis=1, inplace=True )
x = train_data.select_dtypes( exclude='object' )
x_test = test_data.select_dtypes( exclude='object' )

imputer = SimpleImputer()

imp_val = imputer.fit_transform( x )
x = pd.DataFrame( imp_val, columns=x.columns )

imp_val = imputer.transform( x_test )
x_test = pd.DataFrame( imp_val, columns=x_test.columns )

model = RandomForestRegressor( random_state=1 )
model.fit( x, y )

preds = model.predict( x_test )

output = pd.DataFrame( {
    'Id': test_data.index,
    'SalePrice': preds
} )

output.to_csv( 'submission.csv', index=False )
