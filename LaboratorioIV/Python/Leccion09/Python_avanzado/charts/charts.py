import matplotlib.pyplot as plt 

def generate_bar_chart(name, Labels, values):
    fig, ax = plt.subplots()
    ax.bar(labels, values)
    plt.savefig(f'./imgs/{name}.png')
    plt.close()

def generate_pie_chart(Labels, values):
    fix, ax = plt.subplots()
    ax.pie(values, Labels=labels)
    ax.axis('equal')
    plt.savefig('bar.png')
    plt.close()

if __name__ == '__main__':
    labels = ['a', 'b', 'c']
    values = [10, 40, 400]
    
    #generate_bar_chart(labels, values)

    generate_pie_chart(labels, values)
