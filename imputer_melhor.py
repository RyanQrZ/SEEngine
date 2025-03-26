#! /bin/python3

import pandas as pd
from sklearn.ensemble import RandomForestRegressor
from sklearn.impute import SimpleImputer

train_data = pd.read_csv( './train.csv', index_col='Id' )
test_data = pd.read_csv( './test.csv', index_col='Id' )

train_data.dropna(  subset='SalePrice', inplace=True )
y = train_data.SalePrice
train_data.drop( 'SalePrice', axis=1, inplace=True )
x = train_data.select_dtypes( exclude='object' )
x_test = test_data.select_dtypes( exclude='object' )

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

imp_vals = imputer.transform(x_test)
imputed_x_test = pd.DataFrame( imp_vals, x_test.columns )

preds = model.predict( imputed_x_test )

output = pd.DataFrame( {
    'Id': test_data.index,
    'SalePrice': preds
} )

#output.to_csv( 'submission.csv', index=False )
