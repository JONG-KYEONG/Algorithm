import sys
import heapq
input = sys.stdin.readline
INF = int(1e12)

def dijkstra(start):

    q=[]

    for i in range(K+1):
        distance[i][start] = 0

    heapq.heappush(q,(0,start,K))

    while q:
        dist,cur,k = heapq.heappop(q)

        if distance[k][cur] < dist :
            continue

        for i in graph[cur]:
            next,cost = i

            if distance[k][next] > distance[k][cur] + cost:
                distance[k][next] = distance[k][cur] + cost
                heapq.heappush(q,(distance[k][next],next,k))

            if k>=1:
                if distance[k-1][next] > distance[k][cur]:
                    distance[k-1][next] = distance[k][cur]
                    heapq.heappush(q,(distance[k-1][next],next,k-1))

N,M,K =map(int,input().split())
graph=[[]for i in range(N+1)]

for i in range(M): #도로 표현

    a,b,c = map(int,input().split())
    graph[a].append((b,c))
    graph[b].append((a,c))
    #아래층으로 내려가기


distance=[[INF]*(N+1) for i in range(K+1)]

dijkstra(1)
result=[]
for i in range(K):
    result.append(distance[i][N])

print(min(result))
