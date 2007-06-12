SELECT lca.nodeId, lca.label, 
       pA.distance AS distance_a, pB.distance AS distance_b
FROM Node lca, NodePath pA, NodePath pB
WHERE pA.parent_node_id = pB.parent_node_id
AND   lca.node_id = pA.parent_node_id
AND   pA.child_node_id = 12 
AND   pB.child_node_id = 14
ORDER BY pA.distance

