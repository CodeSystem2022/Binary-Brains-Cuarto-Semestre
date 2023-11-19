from typing import List
import charts
import read_csv
import utils

def run():
    data = read_csv.read_csv('./data.csv')  # Leemos el csv
    data = List(List(filter(lambda item: item['Continent'] == 'South America', data)))


    countries = List(map(lambda x: x['Country'], data))
    percentages = List(map(lambda x : x['World Population Percentage']))
    charts.generate_pie_chart(countries, percentages)

    country = input('Type country => ')
    print(country)

    result = utils.population_by_country(data,country)

    if len(result >0) :
       country = result[0] #sobreescribimos la variable
       print(country) #visualizamos el diccionario
       labels, values = utils.get_population(country) #recibimos la población
       charts.generate_bar_chart(country['Country'], labels, values)

    
if __name__ == '__main__':
    run()