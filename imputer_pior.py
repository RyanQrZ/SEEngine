#! /bin/python3

import pandas as pd
from sklearn.ensemble import RandomForestRegressor
from sklearn.impute import SimpleImputer

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
